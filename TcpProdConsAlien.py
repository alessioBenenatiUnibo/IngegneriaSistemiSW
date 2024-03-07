import socket

host="localhost"
port=8888
msg=b"msg( request, request, python_alien, cons_java, hello, 1)\n"
with socket.socket(socket.AF_INET,socket.SOCK_STREAM) as s:
    print("connection to host...")
    s.connect((host,port))
    print(b"sending b'"+msg+b"' to cons...")
    s.send(msg)
    
    msg=b""
    c=s.recv(1024)
    msg+=c
    while(not msg.endswith(b'\n')):        
        c=s.recv(1024)
        msg+=c

    print(msg)


    

