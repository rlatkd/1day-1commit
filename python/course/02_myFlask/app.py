from flask import Flask, render_template, jsonify
from flask import request
import json

app = Flask(__name__, static_folder='./resources/', static_url_path='/')
app.config['JSON_AS_ASCII'] = False

# templates 폴더를 생성

@app.route('/')
def index():
    # 클라이언트 요청에 대한 처리 작업을 수행
    # 처리 결과를 템플리트를 사용하여 보여준다.
    data = {'name': '김기희', 'age': 20}
    return render_template("index.html", **data)

@app.route('/login')
def login():
    data = {'name': '김기희', 'age': 20, 'status': 200}
    return jsonify(data)

# GET http://localhost/signin?name=edison&age=50
@app.route('/signin', methods=['GET'])
def signin():
    name = request.args.get('name', 'No Name')
    age = request.args.get('age', 0)
    return f"이름 : {name}, 연령 : {age}"

@app.route('/signup/<email>')
def signup(email):
    return f"{email}주소에 대한 요청을 처리합니다."

@app.route('/form', methods=['POST'])
def formtest():
    name = request.form['name']
    major = request.form['major']
    return f"이름 : {name}, 전공 : {major}"
    

app.run(host='0.0.0.0', port=80, debug=True)