import os


uname_value = os.environ.get('UNAME')
uage_value = os.environ.get('UAGE')

if uname_value is not None:
    print(f"UNAME is {uname_value}")
else:
    print("UNAME is not set")
    
if uage_value is not None:
    print(f"UAGE is {uage_value}")
else:
    print("UAGE is not set")