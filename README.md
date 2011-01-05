NABUCCO Framework (README)
==========================

NABUCCO Framework - Component Based and Model-Driven Development
The NABUCCO Framework is the modern approach for developing software in a model-driven way using a component model.

Requirements
------------
The Frameworks available in the Open Source environment for MDA and component based development are difficult to combine for an integrated solution. The NABUCCO Framework closes this gap and provides an extensive construction kit of subject-specific and technical solutions. The concepts required in the Enterprise environment (for example, multi-client capability, client-specific customizability, scalability and much more) are already an integral component of the Framework.

Overview
--------
* Tool neutral MDA approach with textual DSL
* DSL for components, services, data-types etc.
* User Interface for RCP, Web and Portal
* Eclipse Generator Plugin
* Supported by UML2 and other meta-models
* Direct creation of Java, XML
* Integrated up-to-date documentation
* Short turnaround times with the development
* Extendable through customized DSL
* NABUCCO is 100% Open Source

Solutions
---------
The NABUCCO Framework consists of an MDA approach with a separate DSL, as well as components based thereon, for the development of products and customized applications.

Objectives
--------------------------------
* Creation of reusable components
* Complete multi-client capability of all components
* Depiction of recurring functions (Best Practices)
* Independence from tools and special technologies
* Supported by UML as well as textual DSLs
* Fast development, paired with qualitatively high value results


Contact
-------
*Find more Information on our [website](http://nabuccosource.org/).*

*The complete documentation may be found on our [Confluence](http://www.nabucco-source.org/confluence/). Sign up for free to add comments and help us to improve NABUCCO.*

*Found any bugs? Want to track improvements? Report them in our public [Jira](http://www.nabucco-source.org/jira/).*


org.nabucco.framework.common.dynamiccode
==========================================
In order to ensure complete multi-client capability for all NABUCCO components, it must be possible to maintain the information in the system dynamically. This maintenance applies the Dynamic Code component.

In doing so, internal lists (such as CLIENT for example) as well as component specific lists are managed conveniently. This means that the customization for customer-specific requirements does not take place in the code and for that reason NABUCCO delivers a separate component inclusive of a User Interface.

At the same time, the lists are maintained in a tree hierarchy and can be read by all the other components.

The main functions are:

* Dynamic definition of enumerations
* Flexible alterations of literals in the duration (for example in drop-down boxes)
* Client independent maintenance of literals
* Grouping of literals
* Fast selection of literals through configurable paths