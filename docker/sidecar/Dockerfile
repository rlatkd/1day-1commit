FROM    ubuntu
RUN     apt-get update && apt-get install -y git
RUN     mkdir /myapp
WORKDIR /myapp
COPY    cloner /myapp/
RUN     chmod a+x /myapp/cloner
CMD     [ "/myapp/cloner" ]