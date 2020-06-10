# My_Personal_Repository
Arogya@Home Project

This repository is to update WiT Hackathon work

Aarogya@home WIT Hackathon submission document
Dtd : 8-June-2020

Aarogya@home
This document puts together all the elements of our “WIT Covid Call for Code” submissions. 
Contents
1.	Short description
Our submission is of a mobile app which Covid patients can use to check if home quarantine is advisable for him or not and also purchase various healthcare services and products based on recommendations from the app. 

2.	Long description
What is the problem ? 
India’s healthcare infrastructure is not able to scale up to the need of Covid19 pandemic. News of hospitals overflowing and patients dying while waiting for a hospital bed, are now very common. We often find heart-wrenching stories of death – both Covid and non-Covid patients in social media and also in mainstream media. We are in desperate need of an alternate solution where patients can recover without making a trip to a hospital. 
Our economy also needs help as many businesses and workers lost their income opportunity. 
How have you solved it? 
Our humble attempt is to facilitate a new healthcare ecosystem supporting Covid patients recover while staying at home. 
This would reduce load on the hospitals. Patients can recover in the comfort and hygine of their own homes and possibly at much lesser cost than a pvt. Hospital. This solution will boost a new genre of healthcare business, and will help economy at large.
We envision a platform aggregating various service providers and product vendors who contribute towards this goal. A mobile app linked to this platform will be available to the public. This could be a complementary app to Govt of India’s Aarogya Sethu app. While Aarogya Sethu will help in protecting one catching the virus, online doctor’s consultation and with all important information, our “Aarogya at home” App’s focus is purely on the post diagnosis journey of the patient. 
Please note that in this Hackathon, we focused on developing the user experience in the patient’s mobile app and the healthcare ecosystem platform and supplier portals are in the roadmap. 

![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-1.png)


 
User journey: 
Covid patient will use “Aarogya at home” app :
a)	To check if his living condition is suitable for home-quarantine.  

![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-2.png)


b)	To look for certain facilities at home. This App will ask few questions to the patient and recommend most suitable products and services. 

 ![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-3.png)
 
 ![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-4.png)
 
c)	Based on App’s recommendation or otherwise, patient can enquire about the availability and delivery timeline of the services and products.
 
![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-5.png)


![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-6.png)
 
d)	Finally, place the order to the supplier. 
 ![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-7.png)
 
 
 ![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-8.png)
 
 
 ![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-9.png)
 
 
We expect that suppliers will come up with lots of innovative ideas of products and services. 
However, for the purpose of the demo, we have built a sample data-set of offers divided into two categories –
a)	Complete Covid Management Services including range of equipment and services. 
b)	A la Carte Offers like buying/renting of equipment, booking healthcare professionals for home-visit or on-line consultation.  
We have used Android Studio and SQLite to build the App. IBM Watson’s BOT and API service helped us to build the conversational experience for ‘home quarantine eligibility check’ and also ushering towards product recommendation. The core product recommendation engine is a bespoke one. 

Data Model for offers:
 
![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-10.png)


3.	Solution Roadmap
In this hackathon, our aim was to build the mobile-app based customer experience. The backend platform aggregating the suppliers is in the roadmap, which we expect to complete within a month’s time. 

Following is the complete E2E Architecture diagram to support the roadmap functionalities. 

![alt text](https://github.com/amritamaulik/My_Personal_Repository/blob/master/WIT%20Hackathon%20Images/img-11.png)



We shall move the db on cloud, and wrap it by an API layer. We shall build web portal for the Suppliers. 
Patient’s App and Supplier’s portal will interact with the database via the APIs and will also use cloud based notification service. 
We shall also build a secured Identity and Access Management functionality for patients and suppliers.   

We plan to build the partner eCo system using AWS cloud services.  Central database will be DynamoDB in AWS, which would interact with Vendor portals and Customer’s mobile app via AWS APIGWs. 
Customer and Vendor’s login and access will be managed by AWS Cognito authentication service. 

Customer experience in mobile app will continue to be supported by IBM Watson service and API. 


4.	Link to publicly accessible GitHub repository :

https://github.com/amritamaulik/My_Personal_Repository

5.	Link to 3 minute demo video :

              https://youtu.be/cVnyf0XfPhI

6.	Complete user journey demo video:

Check for Home quarantine recommendation : 
VID 20200608 WA0003 

Product/Service purchase : 
VID 20200608 WA00011 


7.	List of IBM Cloud services/ systems used :

IBM Watson based Automated Chat BOT
IBM Watson APIs to integrate the BOT with Android App

8.	Email addresses of the team members

1.	Commander : Aditi Mazumder , aditim@techmahindra.com
2.	Team member : Amrita Maulik, AM00463215@TechMahindra.com
3.	Team member: Nupoor Tendolkar, NT00551479@TechMahindra.com
4.	Team member : Amita Chavan , AC00564941@TechMahindra.com


9.	Special acknolwdgement : 

Aarogya@home team is extremely grateful to Mr. Kamal Omprakash Hajari ( https://www.linkedin.com/in/kamal-hajari-3b379357 )for his able guidance towards Android app development. 
•	Mr. Kamal Omprakash Hajari
•	Email : kamalhajari123@gmail.com
