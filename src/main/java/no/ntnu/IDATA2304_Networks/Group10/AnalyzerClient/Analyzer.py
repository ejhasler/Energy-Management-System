import socket 
import pandas as pd
import numpy as np
from socket import *

# Get server host IP address and port number
HOST = 10.22.185.110
PORT = 8888

# Create socket
clientSocket = socket(AF_INET, SOCK_STREAM)

try:
    # Try connecting to the provided host
    clientSocket.connect((HOST, PORT))
    print ("\nConnection Successful!")

    # Get the filename
    filename = raw_input('/Test_data/Bok1.csv')

    # Send the HTTP request message
    clientSocket.send("GET /" + filename + " HTTP/1.1\r\n" +
                      "Host: " + gethostbyname(gethostname()) + ":" + str(clientSocket.getsockname()[1]) + "\r\n\r\n")

    print ("\n\n---------------HTTP RESPONSE---------------\n")

    # Receive one HTTP response header line
    response = clientSocket.recv(1024)
    print (response)

    # Receive the file
    fileData = clientSocket.recv(10000)
    print (fileData)

    print ("---------------END OF HTTP RESPONSE---------------\n")

    # Close the connection
    clientSocket.close()

except error:
    print ("Error while connecting!")
    clientSocket.close()

#data = pd.read_csv('data/test.csv')

#sensor = np.array(data["Sensor"])
#date = np.array(data["date"])
#kwh = np.array(data["Kwh"])


#i = 0

#while (i < 10):

 #   packet = "yarraruyarrari"

  #  i+=1

   # with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    #    s.connect((HOST, PORT))
     #   s.send(packet.encode("utf-8"))

