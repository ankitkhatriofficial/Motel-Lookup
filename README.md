# Motel-Lookup
http://motel-lookup.herokuapp.com/ (Login with username:- "KHATRI" and password:- "khatri@09")

About Motel-Lookup
__________________
This is an MVC based project which let you filter the hotel according to states and custom search. This project is developed in Maven FrameWork(Java Web-frameWork).

How to Run this Application on Localhost?
_________________________________________
Download the Project "Motel Lookup" and extract the .zip file.
You will get Motel Lookup Folder inside Motel-Lookup-master Folder.
Open Eclipse IDE and go to File and click on import.
Select "Maven" as import wizard and click on Existing Maven Projects.
Now Browse the "Motel-Lookup" Folder.
Now Eclipse IDE will take some time to import the Maven Project because it needs to download some dependencies, you can check it in console what process is happening.
when the "Motel-Lookup" (Maven Project) is successfully imported. All you need to do is Right-Click on Motel-Lookup Project in Eclipse and select Run as.
Now, you will get a lot of options, there will be also two "Maven build" option.
click on last "Maven build" and a pop-up will occur.
Type "tomcat7:run" in the Goals field and click on Run.
This will take a while since maven verifies and validates all the codes and build it.
In the Console, you can see this "Running war on http://localhost:8080/" somewhere, that means your project is running on this url.
In case, you get a different URL in the console, copy it and paste it in your browser.
There you go, Motel-Lookup Web App is working fine...!
You can use Default username and password to login or can edit username or password in LoginService.java file.
