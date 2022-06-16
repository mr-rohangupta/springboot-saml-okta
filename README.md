# springboot-saml-okta

**Introduction**

**_springboot-saml-okta is a Spring Boot application to demonstrate the Single Sign On process with SAML(Security Assertion Markup Language) and OKTA_**

**_This application provides you with an example of Sign in with the db and also sign it with SSO via Okta using SAML_**

**Getting Started**

**_Before Starting you need to create an OKTA account using [okta.com/integrate/signup]()_**

**_Once you are in using Google Sign-in create a new Application(Create a new app integration)_**

**_From the options use the option SAML 2.0 and next_**

**_In the General Setting give the application name and click next_**

**_Now you are in configure SAML page in Single sign on URL option put [http://localhost:8080/saml/SSO](https://localhost:8443/saml/SSO) and in Audience URI put [http://localhost:8080/saml/metadata](https://localhost:8443/saml/metadata) and next_**

**_Once done then select the first radio button I'm an Okta customer adding an internal app_**

**_And the checkbox This is an internal app that we have created and Finish_**

**_Now your application is successfully created now go to sign on tab and copy the Identity Provider Metadata URL and put in application.properties under saml.metadataUrl_**

**_Then go to View Setup Instructions and copy Identity Provider Issuer and put under saml.idp inside application.properties file_**

**_Inside application.properties there is one property which is saml.sp there you need to give http://localhost:8080/saml/metadata_**

**_Here the OKTA setup is finished_**

**KeyStore Setup**

i) **_For Setting up Key Store please navigate to src/main/resources/saml folder._**

ii) **_Here in this folder keystore command is not recognized, so you need to set here the JRE path._**

iii) **_In Intellij idea terminal now you are inside SAML folder type "**set PATH=C:\Program Files\Java\jre1.8.0_281\bin**" and press enter._**

iv) **_Once done you need to use the below command_**

v) **_"keytool -genkey -v -keystore keystore.jks -alias springoktasaml -keyalg RSA -keysize 2048 -validity 10000"_**

v) **_Give the password as secret Hit Enter and Enter finally just enter yes and give the password_**

vi) **_Now with the keytool command we need to take the alias name which is springoktasaml and configure in saml.keystore.alias property_**

vii) **_Then the password which is secret and configure in saml.keystore.password and finally the saml.keystore.location as "classpath:/saml/keystore.jks"_**