from twilio.rest import Client
import random
 
otp=random.randint(1000,9999)
 
auth_sid="AC75a6bc833f162c923a963d1eadf21ca2"
auth_token="6bdbfc23c5b8df3ca971367942ab2813"
 
client=Client(auth_sid,auth_token)
 
message=client.messages.create(
    body="Dear  Donar,this is to inform you that you are elligible for donating blood again. Please do consider donating as your small gesture might be life saving for someone...Stay Healthy!!!",
    from_="+15627845609",
    to="+918579088702"
    )
#f"Your OTP is : {otp}"
#file=open("login_status.txt","w+")
#entry=int(input("Enter OTP : \n"))
#if(entry==otp):
#    file.write("1")
#else:
#    file.write("0")
 #
#file.close()
