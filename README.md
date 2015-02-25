
# Introduction

This scala project uses play framework with multiple modules in it. This project has 3 submodules,
moduleA - play module (means "PlayScala" plugin enabled)
moduleB - play module (means "PlayScala" plugin enabled)
commons - non-play module

## why multimodules?

* Service Layer - play framework have a standard folder structure makes it little bit difficult to introduce modular separately deployable services. 
* Modularity - can separate the modules by functionality 
* Play / Non-play module - enable “PlayScala” plugin for the module to create it as play application otherwise it can be a non-play module
* Reusability - package the non-play module and reuse them as a library.
* Multiple play application inside same application [configuration, routes]

# Setup

Required Tools - Git, JDK 1.6+ (optionally, you may need to have SBT)

Clone the project and do the following steps:

```
~play-multimodule-demo> chmod 777 ./sbt/bin/sbt

~play-multimodule-demo> ./sbt/bin/sbt

[play-multimodule-demo] 
The command "projects" should list down the multiple modules in this project

[play-multimodule-demo] $ projects
[info] In file:/Users/sureshprakasam/Code/play-multimodule-demo/
[info] 	   commons
[info] 	   moduleA
[info] 	   moduleB
[info] 	 * root

To run the play application,

[play-multimodule-demo] $ run

Using REST API client, try to hit the API endpoints on this play app (see below section "API Endpoints")

To package the sub modules separately,

[play-multimodule-demo] $ dist
```

# Configuration
TBD

# Routes
TBD

# API Endpoints

## root module endpoints
* GET /index
* GET /allConfig

## moduleA         
* GET /moduleA/index
* GET /moduleA/splitUrl?url="http://www.google.com"
* GET /moduleA/allConfig

moduleB         
* GET /moduleB/index
