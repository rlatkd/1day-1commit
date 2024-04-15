FROM    ubuntu:latest
RUN     apt-get update  &&  apt-get install -y git
COPY    ./contents-cloner  /contents-cloner
RUN     chmod  a+x  /contents-cloner
WORKDIR /
CMD     ["/contents-cloner"]