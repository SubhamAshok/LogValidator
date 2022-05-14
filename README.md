# Problem Statement

## Requirements for this coding assessment 

* Java 8
* Use of any open-source library is allowed
* Your program must use either the Gradle or Maven build system to resolve dependencies, build and test
# Summary of task
Our custom-build server logs different events to a file named logfile.txt. Every event has 2 entries in the file 
 one entry when the event was started and another when the event was finished. The entries in the file 
have no specific order (a finish event could occur before a start event for a given id)  
Every line in the file is a JSON object containing the following event data:
* id - the unique event identifier
* state - whether the event was started or finished (can have values "STARTED" or "FINISHED"
* timestamp - the timestamp of the event in milliseconds  
  
Application Server logs also have the following additional attributes:
* type - type of log
* host - hostname
2
Example contents of logfile.txt:
![image](https://user-images.githubusercontent.com/65991579/168409028-990be305-f06d-42ea-8653-4cf5a8b89379.png)

In the example above, the event scsmbstgrb duration is 1491377495216 - 1491377495213 = 3ms
The longest event is scsmbstgrc (1491377495218 - 1491377495210 = 8ms)
## The program should:
* Take the path to logfile.txt as an input argument
* Parse the contents of logfile.txt
* Flag any long events that take longer than 4ms
* Write the found event details to file-based HSQLDB (http://hsqldb.org/) in the working folder
* The application should create a new table if necessary and store the following values:
* Event id
* Event duration
* Type and Host if applicable
* Alert (true if the event took longer than 4ms, otherwise false)
## Additional points will be granted for:
* Proper use of info and debug logging
* Proper use of Object Oriented programming
* Unit test coverage
* Multi-threaded solution
* Program that can handle very large files (gigabytes)
## As stated above, submissions should be loaded onto Github

# LogValidator- How to execute
To run the program:
1. simply click on code->download as zip
2. extract the rar file
3. open eclipse click on file>import navigate to the and import it
4. Open the following package
   YourDownloadLocation/LogValidator/src/main/java/com/creditsuisse/LogValidator/
5. Launch App.java file from eclipse
6. Run the App.java file inside com.creditsuisse.LogValidator package <br>
OR<br>
1. Open CMD and clone the repo with command : git clone https://github.com/SubhamAshok/LogValidator_CrediSuisse
2. then navigate to that folder by command: cd C:/LogValidator_CrediSuisse/LogValidator
3. then run the program by command: mvn clean compile exec:java
 
Note: JDK and Maven enviornment variables must be set in order to run the program<br>
*Sample Output*
![002](https://user-images.githubusercontent.com/65991579/143783526-5a4b8296-cf44-412a-9856-8a753f66d1ce.jpg)
![001](https://user-images.githubusercontent.com/65991579/143783527-7a405eaa-9563-4dc2-917e-d7fb494d9d8f.jpg)
