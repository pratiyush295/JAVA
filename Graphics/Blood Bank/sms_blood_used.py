from twilio.rest import Client
import random
 
otp=random.randint(1000,9999)
 
auth_sid="AC75a6bc833f162c923a963d1eadf21ca2"
auth_token="6bdbfc23c5b8df3ca971367942ab2813"
 
client=Client(auth_sid,auth_token)
 
message=client.messages.create(
    body="Dear  Donar,this is to inform you that your blood has been used to save SWAPNEEL's life...Stay Healthy!!!",
    from_="+15627845609",
    to="+918579088702"
    )
