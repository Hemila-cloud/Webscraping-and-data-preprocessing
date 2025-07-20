# Webscraping and Data Preprocessing

This project demonstrates web scraping, data cleaning, and preprocessing using Java.

## Features

- Scrapes data from [Simple Wikipedia: List of Indian Scientists](https://simple.wikipedia.org/wiki/List_of_Indian_scientists) using Python.
- Cleans and preprocesses the scraped CSV data by handling missing values and removing outliers using Java.
- Uses Apache Commons CSV and other libraries for CSV handling in Java.
- Saves cleaned data to a new CSV file for further analysis.

## Prerequisites

- Java Development Kit (JDK) installed
- Apache Commons CSV, Commons IO, and Commons Codec libraries (`.jar` files) added to the project

## How to Run

1. Run the Python scraper to get the raw data CSV.
2. Compile the Java preprocessing code:
   ```bash
   javac -cp ".;libs/commons-csv-1.14.0.jar;libs/commons-io-2.20.0.jar;libs/commons-codec-1.18.0.jar" Main.java
