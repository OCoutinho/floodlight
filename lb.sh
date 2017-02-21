#!/bin/sh
 
curl -X POST -d '{"id":"1","name":"vip1","protocol":"icmp","address":"10.0.0.100","port":"8"}' http://localhost:8080/quantum/v1.0/vips/
curl -X POST -d '{"id":"1","name":"pool1","protocol":"icmp","vip_id":"1"}' http://localhost:8080/quantum/v1.0/pools/
curl -X POST -d '{"id":"1","address":"10.0.0.3","port":"8","pool_id":"1"}' http://localhost:8080/quantum/v1.0/members/
curl -X POST -d '{"id":"2","address":"10.0.0.4","port":"8","pool_id":"1"}' http://localhost:8080/quantum/v1.0/members/
 
curl -X POST -d '{"id":"2","name":"vip2","protocol":"tcp","address":"10.0.0.200","port":"100"}' http://localhost:8080/quantum/v1.0/vips/
curl -X POST -d '{"id":"2","name":"pool2","protocol":"tcp","vip_id":"2"}' http://localhost:8080/quantum/v1.0/pools/
curl -X POST -d '{"id":"3","address":"10.0.0.5","port":"100","pool_id":"2"}' http://localhost:8080/quantum/v1.0/members/
curl -X POST -d '{"id":"4","address":"10.0.0.6","port":"100","pool_id":"2"}' http://localhost:8080/quantum/v1.0/members/
 
curl -X POST -d '{"id":"3","name":"vip3","protocol":"udp","address":"10.0.0.150","port":"200"}' http://localhost:8080/quantum/v1.0/vips/
curl -X POST -d '{"id":"3","name":"pool3","protocol":"udp","vip_id":"3"}' http://localhost:8080/quantum/v1.0/pools/
curl -X POST -d '{"id":"5","address":"10.0.0.7","port":"200","pool_id":"3"}' http://localhost:8080/quantum/v1.0/members/
curl -X POST -d '{"id":"6","address":"10.0.0.8","port":"200","pool_id":"3"}' http://localhost:8080/quantum/v1.0/members/
