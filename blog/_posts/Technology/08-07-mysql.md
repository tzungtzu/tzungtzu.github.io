#排序


mysqldump -h 172.31.20.101 -u risk -p  temp hubo_firstbill_dpd90 > hubo.sql

scp -i ~/Workspace/keys\&/dataModelingRuntime.pem ubuntu@13.228.227.208:/home/ubuntu/hubo.sql ~/Downloads