# Gold Price 

Fetch the latest Gold Price. 


The project makes use of IBJA's website to parse Gold Prices.

## How To
To fetch gold price on your command line: 

> python gold_price/fetch_price.py

The response will be a Python dictionary 
> {'current_time': '30-09-20yyy 21:45  GMT +5:30 Asia/Kolkata', 
>  '24_karat_price': '5044.00', 
>  '22_karat_price': '4620.00'}

___

## Required Packages:
The packages required are: 
 
```
bs4==0.0.1
requests==2.24.0
```