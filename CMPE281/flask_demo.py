from flask import Flask
import urllib3
import sys

http = urllib3.PoolManager()
r = http.request('GET', str(sys.argv[1]))

app = Flask(__name__)

@app.route('/')
def index():
    return r.data


if __name__== '__main__':
    app.run(debug=True)
