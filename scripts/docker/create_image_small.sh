#!/bin/bash
IMAGE_NAME=scorp_74/small_image

pushd ../../

docker build -t $IMAGE_NAME .

docker image ls | grep $IMAGE_NAME