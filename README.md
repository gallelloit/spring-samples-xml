# spring-samples-xml
Plain and simple Spring samples using XML configuration.

# Configuration

* Spring 5.8.0

# Use case

Simple and plain Spring samples repository that uses main java classes to test each case.
It includes basic functionality:

* Creating and retrieving beans
* Bean Lifecycle
* Bean Scope

# Getting started

To get this Maven project working:

* Clone this repo
* Build using Maven
* In your IDE, get to the com.gallelloit.springdemo.main package, and execute each of the proposed Demo Main Apps
* Play around
  
# Proposed Demo Main Apps

## Demo01BasicSpringXmlApp.java:

It gets the bean myCricketCoach, which implements the interface Coach

The values of the plain private properties in CricketCoach implementation are fetch from sports.properties
This configuration is specified also in the applicationContext.xml:

* First tell Spring a placeholder property: <context:property-placeholder location="classpath:sport.properties"/>
* Then, in the bean definition, define the values of the properties using the values in the file:
	* `<property name="emailAddress" value="${foo.email}"></property>`
	* `<property name="team" value="${foo.team}"></property>`

This coach implementation uses internally the implementation RandomFortuneService of interface FortuneService

## Demo02LifeCycleXmlApp.java:
 
Simple Spring application that creates a context from a XML file (beanLifeCycle-applicationContext.xml)
It gets the bean myTrackCoach, which implements the interface Coach
Coach interface uses internally the implementation HappyFortuneService
of FortuneService interface

In this example application, Spring beans lifecycle is shown. The track coach implementation
overrides the lifecycle methods ini-method and destroy-methods. They are configured in the
beanLifeCycle-applicationContext.xml file and executed,
as indicated in their names, right after the constructor and right before destroying
of the bean.

Some displays are shown for debug and testing purposes.

## Demo03BeanScopeXmlApp.xml

Spring application that creates a context from a XML file (beanScope-applicationContext.xml)
It gets the bean myFootballCoach, which implements the interface Coach
This coach implementation uses internally the implementation HappyFortuneService of interface FortuneService

The resolved issue of this example is checking the two most used bean scopes from Spring: Singleton and Prototype

In the xml, two alternative versions of the bean definition are specified.

If the first one is uncommented, singleton approach will be used.
If the second one is uncommented, it will bye prototype.

* On the one side, Singleton will make Spring to create and return one instance of the bean no matter how many
times the bean is retrieved. You can see in the example how the memory location for the two retrieved objects
is the same.
* Whereas when Prototype strategy is defined, any time a new bean is requested to the container, a different
instance is created and retrieved. The test can be performed commenting the first myFootballCoach bean
in the beanScope-applicationContext.xml and commenting out the second one.
