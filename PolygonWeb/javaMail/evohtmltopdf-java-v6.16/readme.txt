EVO HTML to PDF Converter for Java
==================================

In order to use the EVO HTML to PDF Converter for Java you first have to install the EVO HTML to PDF Server. The server 
installation instructions can be found below.

The EVO HTML to PDF Converter library for Java requires JRE 1.6 or a later version.

EVO HTML to PDF Converter Server
================================

EVO HTML to PDF Converter Server can run either in a Windows Service on a Windows machine or in an Azure Cloud Service 
deployed in Microsoft Azure cloud.


Option 1. Running the Server in a Windows Service
=================================================

The Windows Service and your WinRT application can run on the same machine or they can run on different machines. If 
both the server and application run on the same machine then no additional settings are necessary, otherwise you have 
to make sure that the server TCP port (40001 by default) is opened in the firewall of the Windows machine where the 
service is hosted. The Windows machine must have .NET 4.0 or later installed.

Service Installation
--------------------

The setup.exe from 'Windows' folder will guide through the installation process. You'll be able to select the IP address 
and port number on which the server will run, you can set an optional service password, you can choose if the server will 
run under the predefined 'Local System Account' or under a user account for which you'll be required to provide the 
username and password. At the end of the installation process you can choose to start the server.

Service Uninstallation
----------------------

To uninstall the server use the normal Windows uninstall procedure. In Windows Control Panel, choose 'Programs and Features', 
choose the 'EvoHtmlToPdfService' program and then click the 'Uninstall' button.


Option 2. Running the Server in an Azure Cloud Service
======================================================

To run the HTML to PDF server in an Azure Cloud Service you have to deploy the package from 'Azure' folder.

Login into your Microsoft Azure portal and create a new Cloud Service. In the first screen select an URL for your cloud service, 
the resource group, location and then open the dialog to select a package. In the package upload dialog choose a name 
for deployment and browse to 'Azure' local folder to choose the 'EvoHtmlToPdfAzureService.cspkg' file for package 
option and 'ServiceConfiguration.Cloud.cscfg' file for configuration option. Enable the 'Deploy even if one or more roles contain 
a single instance' option and finish the wizard.

The deployment can take a few minutes. When the deployment finished and service is running, enter the cloud service settings 
and go to general properties in input endpoints section where you can find the service IP address and port number. 
You will use this input point details to connect the client library to service.

In service configuration you can set a service password and the maximum number of conversions running at the same time.
After you changed a configuration parameter you have to restart the service.


Testing the Server Installation
===============================

You can verify that the HTML to PDF server is installed and running using the demo application from runnable JAR file 'demo.jar'.
The application allows you to convert a HTML page from a given URL to PDF or a HTML string to PDF and allows you specify 
the server IP address, server port and the optional service password that you have chosen during the installation process.

If the demo application works as expected then you start using the 'evohtmltopdf-v6.16.jar' library in your own applications.

Contact
=======

For any questions about the software you can contact us at the email addresses displayed on the http://www.evopdf.com/ website.
