@startuml
package com.alibaba.dubbo.remoting.exchange <<Frame>>{
		
	interface Client extends Endpoint, Channel, Resetable {
	    void reconnect() throws RemotingException    
	    void reset(com.alibaba.dubbo.common.Parameters parameters)
	}	

	interface Endpoint {
	    URL getUrl()
	    ChannelHandler getChannelHandler()
	    InetSocketAddress getLocalAddress()
	    void send(Object message) throws RemotingException
	    void send(Object message, boolean sent) throws RemotingException
	    void close()
	    void close(int timeout)
	    boolean isClosed()

	}

	interface Resetable {
	    void reset(URL url)    
	}

	interface Channel extends Endpoint {
	    InetSocketAddress getRemoteAddress()
	    boolean isConnected()
	    boolean hasAttribute(String key)
	    Object getAttribute(String key)
	    void setAttribute(String key,Object value)
	    void removeAttribute(String key)
	}
	interface ExchangeChannel extends Channel {
	    ResponseFuture request(Object request) throws RemotingException
	    ResponseFuture request(Object request, int timeout) throws RemotingException
	    ExchangeHandler getExchangeHandler()
	    void close(int timeout)
	}
	interface ExchangeClient extends Client, ExchangeChannel {

	}
	
	class HeaderExchangeClient implements ExchangeClient {
	    - static final ScheduledThreadPoolExecutor scheduled
	    - int heartbeat
	    - int heartbeatTimeout
	    - final Client client
	    - final ExchangeChannel channel
	   + void send(Object message, boolean sent) 
	   + ResponseFuture request(Object request, int timeout)
	   +  void reset(URL url)
	   +  void reconnect()
	}
	
	interface Server extends Endpoint, Resetable {
	    boolean isBound();
	    Collection<Channel> getChannels();
	    Channel getChannel(InetSocketAddress remoteAddress);
	    void reset(com.alibaba.dubbo.common.Parameters parameters);
	}	
	interface ExchangeServer extends Server {
	    Collection<ExchangeChannel> getExchangeChannels();
	    ExchangeChannel getExchangeChannel(InetSocketAddress remoteAddress);
	}	
	
	class HeaderExchangeServer implements ExchangeServer {
		- final ScheduledExecutorService scheduled
		-  ScheduledFuture<?> heatbeatTimer
		- int  heartbeat
		- int  heartbeatTimeout
		- final Server server
		- volatile boolean closed
		
		+ void send(Object message, boolean sent) 
		+  void reset(URL url)
	}
}



package com.alibaba.dubbo.rpc.protocol.dubbo <<Frame>>{
	interface Protocol {	
	    //@SPI("dubbo")
	    int getDefaultPort()
	    <T> Exporter<T> export(Invoker<T> invoker) throws RpcException //@Adaptive
	    <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException //@Adaptive
	    void destroy()
	}
	
	interface Node {
	    URL getUrl()
	    boolean isAvailable()
	    void destroy()
	}	
	interface Invoker<T> extends Node {
	    Class<T> getInterface()
	    Result invoke(Invocation invocation) throws RpcException
	}	
	
	class DubboInvoker extends AbstractInvoker {
	    - final ExchangeClient[]      clients
	    - final AtomicPositiveInteger index 
	    - final String                version
	    - final ReentrantLock     destroyLock 
	    - final Set<Invoker<?>> invokers
	    # Result doInvoke(final Invocation invocation)	    
	}
	abstract class AbstractProtocol implements Protocol{	
	# final Map<String, Exporter<?>> exporterMap = new ConcurrentHashMap<String, Exporter<?>>()
	# final Set<Invoker<?>> invokers = new ConcurrentHashSet<Invoker<?>>()
	# {static} String serviceKey(URL url) 
	# {static} String serviceKey(int port, String serviceName, String serviceVersion, String serviceGroup) 
	+ void destroy() 
	# {static} int getServerShutdownTimeout() 
	
	}
	
	 abstract class AbstractInvoker implements Invoker {
	    - final Class<T>   type
	    - final URL  url
	    - final Map<String, String> attachment
	   # abstract Result doInvoke(Invocation invocation) 
	}	
	class DubboProtocol extends AbstractProtocol {	
	 + static final String NAME = "dubbo"
	 + static final int DEFAULT_PORT = 20880
	 + final ReentrantLock lock 
	 - final Map<String, ExchangeServer> serverMap 
	 - final Map<String, ReferenceCountExchangeClient> referenceClientMap 
	 - final ConcurrentMap<String, LazyConnectExchangeClient> ghostClientMap 
	 - final Set<String> optimizers 
	 - final ConcurrentMap<String, String> stubServiceMethodsMap 
	 - ExchangeHandler requestHandler
	 
	 + <T> Exporter<T> export(Invoker<T> invoker)
	 - void openServer(URL url)
	}
	
	interface Exporter {
	    Invoker<T> getInvoker()
	    void unexport()
	}	
	
	abstract class AbstractExporter implements Exporter {
	    - final Invoker<T> invoker
	    - volatile boolean unexported
	    + AbstractExporter(Invoker<T> invoker) 
	    + Invoker<T> getInvoker() 
	    + void unexport() 
	}	
	 class DubboExporter extends AbstractExporter {
	    - final String                        key;
	    - final Map<String, Exporter<?>> exporterMap;
	    + DubboExporter(Invoker<T> invoker, String key, Map<String, Exporter<?>> exporterMap)
	    + void unexport()
	}
}

package com.alibaba.dubbo.remoting.transport <<Frame>>{

	abstract class AbstractPeer implements Endpoint, ChannelHandler {
	}
	abstract class AbstractEndpoint extends AbstractPeer implements Resetable {
	}
	abstract class AbstractClient extends AbstractEndpoint implements Client {
	    # abstract void doOpen()
	    # abstract void doClose() 
	    # abstract void doConnect()
	    # abstract void doDisConnect()
	    # abstract Channel getChannel()	
	}
	
	class NettyClient extends AbstractClient {
	- {static} final ChannelFactory channelFactory
	- ClientBootstrap bootstrap
	- volatile Channel channel
	# Channel getChannel()	
	# void doOpen() 
	# void doConnect() 
	# void doDisConnect() 
	# void doClose() 
	}
}

package org.jboss.netty <<Frame>>{
	class Bootstrap implements ExternalResourceReleasable{
	}
	class ClientBootstrap extends Bootstrap {
	    + ChannelFuture connect(SocketAddress remoteAddress) 
	}
	interface ExternalResourceReleasable {
	    void releaseExternalResources()
	}
	interface ChannelFactory extends ExternalResourceReleasable {
	    Channel newChannel(ChannelPipeline pipeline)
	    void shutdown()
	    void releaseExternalResources()
	}
	interface ClientSocketChannelFactory extends ChannelFactory {
	    SocketChannel newChannel(ChannelPipeline pipeline)
	}
	class NioClientSocketChannelFactory implements ClientSocketChannelFactory {
		+ void releaseExternalResources()
		+ void shutdown()
		- void releasePools()
	}
}


@enduml
