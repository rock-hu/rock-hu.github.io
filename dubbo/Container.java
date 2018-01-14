@startuml

package com.alibaba.dubbo.container <<Frame>>{
    class Main{
    	+ {static} void main(String[] args)
    }
    interface Container{
	    void start()
	    void stop()    
    }
}

package com.alibaba.dubbo.container.spring <<Frame>>{
    class SpringContainer implements Container{
	    + {static} final String SPRING_CONFIG = "dubbo.spring.config"
	    + {static} final String DEFAULT_SPRING_CONFIG = "classpath*:META-INF/spring/*.xml"
	    {static} ClassPathXmlApplicationContext context
	    
	    void start()
	    void stop()    
    }
    class DubboNamespaceHandler extends NamespaceHandlerSupport{
	+ void init() 
    }
    class AnnotationBean {
    }
    class ReferenceBean {
    }
    class ServiceBean  {
    
    }
    
}

package com.alibaba.dubbo.config <<Frame>>{
	class ApplicationConfig{
	}
	class ConsumerConfig{
	}
	class ModuleConfig{
	}
	class MonitorConfig{
	}
	class ProtocolConfig{
	}
	class ProviderConfig{
	}
	class RegistryConfig{
	}
}


package com.alibaba.dubbo.container.jetty <<Frame>>{
    class JettyContainer implements Container{
	    + {static} final String JETTY_PORT = "dubbo.jetty.port"
	    + {static} final String JETTY_DIRECTORY = "dubbo.jetty.directory"
	    + {static} final String JETTY_PAGES = "dubbo.jetty.page"
	    + {static} final int DEFAULT_JETTY_PORT = 8080
	    SelectChannelConnector connector

	    void start()
	    void stop()    
    }
    
}

package com.alibaba.dubbo.container.log4j <<Frame>>{
    class Log4jContainer implements Container{
	    + {static} final String LOG4J_FILE = "dubbo.log4j.file"
	    + {static} final String LOG4J_LEVEL = "dubbo.log4j.level"
	    + {static} final String LOG4J_SUBDIRECTORY = "dubbo.log4j.subdirectory"
	    + {static} final String DEFAULT_LOG4J_LEVEL = "ERROR"

	    void start()
	    void stop()    
    }
    
}

package com.alibaba.dubbo.common.extension <<Frame>>{
    class ExtensionLoader{
    
	 + {static} final String SERVICES_DIRECTORY = "META-INF/services/"
	 + {static} final String DUBBO_DIRECTORY = "META-INF/dubbo/"
	 + {static} final String DUBBO_INTERNAL_DIRECTORY = DUBBO_DIRECTORY + "internal/"
	 - final ExtensionFactory objectFactory

    
    	+ {static} <T> ExtensionLoader<T> getExtensionLoader(Class<T> type)
    	+ T getExtension(String name) 
	+ String getDefaultExtensionName()
	+ T getAdaptiveExtension() 
	+ List<T> getActivateExtension(URL url, String[] values, String group)
    }
    
    annotation SPI
    annotation Activate
    annotation Adaptive
    
    interface ExtensionFactory{
        <T> T getExtension(Class<T> type, String name)
    }
    
    class SpiExtensionFactory implements ExtensionFactory{
	<T> T getExtension(Class<T> type, String name)
    }
    
    class AdaptiveExtensionFactory implements ExtensionFactory{
        - final List<ExtensionFactory> factories
	<T> T getExtension(Class<T> type, String name)
    }
}

package com.alibaba.dubbo.rpc <<Frame>>{

}


package com.alibaba.dubbo.rpc.protocol <<Frame>>{


}



@enduml
