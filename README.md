
# TareaDiseñoOOGenerics

This project is a compilation of programs which do the following:

1. Exercise1: A program in which you create a URL object and print on screen each of the data returned by the 8 methods: getProtocol, getAuthority, getHost, getPort, getPath, getQuery, getFile, getRef.

2. Exercise2: A browser application that asks the user for a URL address, reads data from that address, and stores them in a file named resultado.html.

3. EchoServerSquareExercise3: A server that receives a number and responds with the square of this number.

4. EchoServerFuncionsExercise4: A server that can receive a number and respond with an operation on this number. This server can receive a message starting with "fun:", and if it receives this message, it changes the operation accordingly. The server must respond with the sine, cosine, and tangent functions. By default, it should start calculating the cosine. For example, if the first number it receives is 0, it should respond with 1. If it then receives π/2, it should respond with 0. If it subsequently receives "fun
", it should change the current operation to sine, meaning it should calculate sines from that point onwards. If it then receives 0, it should respond with 0.

5. HttpServerExercise5 : t is a web server that handles a request and returns a web page.

6. EchoServerMultiFilesExercise6: A web server that supports multiple consecutive requests (non-concurrent). The server must return all requested files, including HTML pages and images.

7. DatagramTimeClientExercise7: A program that connects to a server which responds with the current time. The program should update the time every 5 seconds based on the server's data. If no new time is received, it should maintain the last known time.

8. ChatRMI: It's a program that can connect to another application of the same type on a remote server to start a chat. The application requests an IP address and a port before connecting to the desired client.


For example, a typical invocation would be:

```
'route the java.exe del jdk' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'class path in target folder' 'edu.escuelaing.arsw.ASE.app.EchoClient'

Examples:

'C:\Program Files\Java\jdk-21\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\juans\OneDrive\Desktop\ARSW\NamesNetworkClientService\target\classes' 'edu.escuelaing.arsw.ASE.app.EchoClient'


C:\Program Files\Java\jdk-21\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\juans\OneDrive\Desktop\ARSW\NamesNektop\ARSW\NamesNetworkClientService\target\classes' 'edu.escuelaing.arsw.ASE.app.EchoServerFuncionsExercise4'
```

### LOC/h Calculation

To calculate LOC, 148 lines of code are taken into account, in 6 hours. So your productivity for this project is **24,6 LOC/h**.

![img.png](Images%2Fimg.png)

## Starting

In order to use the project on your system, you can access the following link and download a compressed file of it.

You can also clone the file using the following command.

```
git clone https://github.com/Richi025/ARWS-NamesNetworkClientService.git
```
if you want to run the application use the command.

```
'route the java.exe del jdk' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'class path in target folder' 'edu.escuelaing.arsw.ASE.app.EchoClient'

Examples:

'C:\Program Files\Java\jdk-21\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\juans\OneDrive\Desktop\ARSW\NamesNetworkClientService\target\classes' 'edu.escuelaing.arsw.ASE.app.EchoClient'


C:\Program Files\Java\jdk-21\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\juans\OneDrive\Desktop\ARSW\NamesNektop\ARSW\NamesNetworkClientService\target\classes' 'edu.escuelaing.arsw.ASE.app.EchoServerFuncionsExercise4'
```



## Previous requirements

It is necessary to have "**Maven**" and "**Java**" installed, preferably in their latest versions. Use Visual Studio Code (IDE), if you want run more easy the proyect.

### * Maven
```
Download Maven at http://maven.apache.org/download.html 

Follow the instructions at http://maven.apache.org/download.html#Installation
```
### * Java

```
Download Java at https://www.java.com/es/download/ie_manual.jsp
```


### Installing

Once you have the cloned project in your repository. Follow the steps below to launch the program successfully

1. Open a terminal and enter the folder where I clone the repository.

2. Use the following command to compile and clean the target directory.
```
mvn clean compile
```
3. Now use the following command to package the project as a JAR file.

```
mvn package
```

4. Now you can run the project using the following command.


You can use the following files.

1. You can run the program by executing the file Exercise1.java. 

![alt text](images/image-1.png)

2. You can run the program by executing the file Exercise2.java.

![alt text](images/image-2.png)

3. You can run the program by first executing the server (EchoServerSquareExercise3) and then the client (EchoClient.java). Now you can enter a number from the client console and the server will respond with its square.

![alt text](images/image-4.png)

4. You can run the program by first executing the server (EchoServerFuncionsExercise4) and then the client (EchoClient.java). Now you can enter a number from the client console and the server will respond with the result of the "cos" function. If you type fun
or fun
, it will switch to these functions and return a response accordingly.

![alt text](images/image-3.png)

5. You can run the program by executing the file HttpServerExercise5.java, then you can open a browser and use the link: "http://localhost:35000/"

![alt text](images/image.png)

6. You can run the program by executing the file EchoServerMultiFilesExercise6.java, then you can open a browser and use the link: or  or "http://localhost:8080/resultado.html"

 "http://localhost:8080/ejemplo.html" 

![alt text](images/image-5.png)

"http://localhost:8080/google.jpg" 

![alt text](images/image-6.png)

http://localhost:8080/resultado.html 

![alt text](images/image-7.png)

7. You can run the program by first executing the server (DatagramTimeServerExercise7) and then the client (DatagramTimeClientExercise7.java). Now, in the client console, you will receive the server's response time every 5 seconds. If you restart the server, the console will show the updated time.

![alt text](images/imagex.png)

8.






## Running the tests

To run the tests you can use the following Maven command

```
mvn test
```
![imgTest.png](Images%2FimgTest.png)

## Design

For the design, the following class diagram was made. In which it was considered to have a class for all the methods that are going to perform operations, the LinkedList class and the main class that uses these methods.




### Phase architecture

To be able to run the application using "*java -jar*" including in the "pom.xml" file and specifying the main class.

```
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.1.0</version>
        <configuration>
          <archive>
            <manifest>
              <addClasspath>true</addClasspath>
              <mainClass>edu.escuelaing.arsw.ASE.app.StatisticalCalculator</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
    </plugins>
```
## Built with

* [Maven](https://maven.apache.org/) - Dependency management
* [java](https://www.java.com/es/) - Programming language

## Versioned

We use [Git](https://github.com/) for version control. For available versions, see the tags in this repository.

## Authors

* **Jose Ricardo Vasquez Vega** - [Richi025](https://github.com/Richi025)

## Date

Wednesday, June 21, 2024

## License

This project is licensed under the GNU license; See the [LICENSE.txt](LICENSE.txt) file for details.