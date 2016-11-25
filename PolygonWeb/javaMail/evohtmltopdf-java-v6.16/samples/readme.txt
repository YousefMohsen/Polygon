EVO HTML to PDF Samples
=======================

Each sample has a bin folder where you can find the precompiled runnable JAR version of the sample and a src folder
where you can find the sample source code.

In order to run the samples you have to install first the EVO HTML to PDF server. You can find the installation instructions 
in the 'readme.txt' file from root folder.

Build and Run Samples
=====================

To build a sample from source code you need to have a version of JDK installed and to make sure that its Bin folder is
in path such that you can execute the compiler and the virtual machine from command line. For example, to compile the
Getting Started demo for HTML to PDF located in 'samples\HtmlToPdf\GettingStarted' folder, launch a command shell
and change the working directory to 'samples\HtmlToPdf\GettingStarted' and then execute the following command:

javac -classpath ..\..\..\..\evohtmltopdf-v6.9.jar GettingStartedDemo.java

The compiled class files are produced in the same folder and you can run the following command to launch the demo application:

java -classpath ..\..\..\..\evohtmltopdf-v6.9.jar GettingStartedDemo