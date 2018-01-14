## Redux    

### Redux Architecture  
![Redux Architecture](https://raw.githubusercontent.com/LarngearTech/codesheep.io/master/pages/2017-01-06-redux-architecture/redux_architecture.png)


![Redux React](http://react-native-workshop.surge.sh/static/media/redux.1b06b588.png)

### React & Redux   
* [react-redux](https://github.com/reactjs/react-redux) - Official React bindings for Redux.
* [redux-logger](https://github.com/evgenyrodionov/redux-logger) - Logger for Redux.
* [redux-thunk](https://github.com/gaearon/redux-thunk) - Thunk middleware for Redux.


### Basics   

https://redux.js.org/docs/Glossary.html 
* State 
Hold your entire app’s state in a single object. The shape of this object matters, since you can slice the object based on key names, and then tie them to reducer functions which only operate on that slice of the state tree. You can also connect (or bind) slices of the state tree to React Components that will be re-rendered when anything in these state slices change. This is the main promise of Redux – to make state management robust and manageable, and testable. 
* Actions  
Actions are payloads of information that send data from your application to your store. They are the only source of information for the store. You send them to the store using store.dispatch().
* Async Action  
* Action Creator  
* Reducers 
Actions describe the fact that something happened, but don't specify how the application's state changes in response. This is the job of reducers.
* Store 
The Store is the object that brings them together. The store has the following responsibilities:    
1. Holds application state;
2. Allows access to state via getState();
3. Allows state to be updated via dispatch(action);
4. Registers listeners via subscribe(listener);
5. Handles unregistering of listeners via the function returned by subscribe(listener).
* Store creator 
In order to setup Redux for your app, the first thing that has to happen is the store must be created and initialized with the initial state, and the middleware and reducer functions that you want to use. In addition to this, in order to pass this Redux store to all your React Components, you have to use a Provider object that you pass to the root of your React Component view hierarchy.
* Store enhancer    
* Dispatching Function  
* Middleware    
* Connect 
The connect function (from react-redux), or it’s annotation/decorator form @connect is a really important function for you to grok. When state changes occur, due to actions being dispatched against the Redux store, this will have to be reflected in your React Components. connect is the thing that makes this happen for you 


### API 
#### Exports  
* createStore(reducer, [preloadedState], [enhancer])
* combineReducers(reducers)
* applyMiddleware(...middlewares)
* bindActionCreators(actionCreators, dispatch)
* compose(...functions)

#### Store  
* getState()
* dispatch(action)
* subscribe(listener)
* replaceReducer(nextReducer)