# SerialCom
A serial communication simplifier program.

# features:
1. very simple to use
2. can define baud rate
3. send and read from serial port
4. get available ports
&...

# How to use?
1. import:  
 import these two files [SerialComCore.jar](https://github.com/Bu64p/SerialCom/blob/main/Jar/SerialComCore.jar) (*simplifier*) and [jSerialComm-2.7.0.jar](https://github.com/Bu64p/SerialCom/blob/main/Jar/jSerialComm-2.7.0.jar) to your project.
2. import:
 add this code top of the Java program to import the main Core:
 
 ```
 import SerialCom.Core;
 ```
 
3. set up:

Define Hardwear:

```
Core Hardwear = new Core(9600);
```

then you must set the port you want to communicate with:

```
Hardwear.setPort(port_number);
```

> (9600 is Baud Rate that depends on your hardwear that you want to communicate.)

also you can define core and set the port you want to communicate with at same time:

```
Core Hardwear = new Core(9600,port_number);
```

# Methods:
| Command | Description |
| ---------- | --------- |
| `Core(int BaudRate) : void` | define the serial port with BaudRate |
| `Core(int BaudRate, int Port) : void` | define the serial port with BaudRate and Port |
| `setPort(int Port) : void` | set or change the port |
| `getPorts() : string array` | return available ports as a string array |
| `getPortStatus() : boolean` | check if the port is open or not and return result as boolean , ```true``` for open state & ```false``` for close state|
| `send(Object input) : void` | first open the port and then send the input to port |
| `receive() : string` | read the serial and return result as string |

> Recommended: use send() and receive() in thread

# example:

[java2arduino_LedPot](https://github.com/Bu64p/java2arduino_LedPot)

    
    
#
 compiled in Java16.   
 also you can compile this [file](https://github.com/Bu64p/SerialCom/blob/main/SerialCom/src/SerialCom/Core.java) in any jdk but be careful about the [jSerialComm-2.7.0.jar](https://github.com/Bu64p/SerialCom/blob/main/Jar/jSerialComm-2.7.0.jar)'s version.


#
<b><i>Code and Design By Eng.Parsa Gh (Bu64p)</b></i>


