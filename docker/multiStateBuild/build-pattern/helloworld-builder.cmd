@REM 두 개의 Dockerfile을 순차적으로 빌드하는 배치 파일


docker image build -t helloworld-build -f Dockerfile-builder .
docker container create --name build-container helloworld-build
docker container cp build-container:/myapp/helloworld .
docker container rm -f build-container


docker image build -t helloworld -f Dockerfile-runtime .
del helloworld
