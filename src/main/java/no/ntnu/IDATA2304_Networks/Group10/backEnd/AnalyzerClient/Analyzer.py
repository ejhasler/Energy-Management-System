import socket 
import pandas as pd
import numpy as np

HOST = '10.22.185.110'
PORT = 8888

data = pd.read_csv('data/test.csv')

sensor = np.array(data["Sensor"])
date = np.array(data["date"])
kwh = np.array(data["Kwh"])


i = 0

while (i < 10):

    packet = "yarraruyarrari"

    i+=1

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((HOST, PORT))
        s.send(packet.encode("utf-8"))

