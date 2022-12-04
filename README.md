# Energy Management System

## Content
* Introduction
* Project Description
* Architecture
* Use

## 1 Introduction
<p>Energy prices are increasing due too the situation the world are in today. The oil companies and the shipping industry are earning money like never before. With the increasing inflation and interest rate, then you see an increasing trend with expensive electricity prices for homes and businesses. People are struggling to pay their bills because of the high prices. So we came up with an idea that will help people and businesses to minimize their electricity consumption</p>

<p> With the Energy Management System application, you get a full overview of your electricity consumption. You see what you use electricity for and can see a chart of the current spot price in your area where you live and how much you use at home. This is a prototype for people who want to take action to reduce electricity consumption at home and businesses.</p>

## 2 Project Description (not done)

### Application
* Generated Data (Raspberry PI?)
* Socket Programming
* Database
* Web

#### Generated Data
<p>In this project, we are generating dummy data for the application. The data include kWh measurements and the date for when that usage took place. The data will be sent to a clientServer where it is going to be formatted and using TCP protocol  </p>

#### Socket Programming
<p> In this section we have choosen to use TCP protocol, instead of UDP. TCP is more realiable and based on point-to-point where we have one sender and one receiver. Also the TCP protocol is connection-oriented and flow controlled.</p>

#### Database
<p> Our DBMS is MariaDB, where we use SQL coding to insert the different tables and attributes we want according to the project goals. The generated data will be stored in the database that will be connected to the web where our values will be displayed as an graph. </p>

#### Web
<p> The web part are going to be coded in CSS, JavaScript, HTML and PHP. The reason we use PHP is because it gives you the flexibility to connect and work with different databases while developing your page.</p>

## Architecture

## Use

