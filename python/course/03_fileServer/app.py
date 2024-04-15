from flask import Flask, request, render_template, redirect, url_for
from os import path
from myMod import get_list
from myCounter import StatusCounter, save_image

static_path = path.join('.', 'resources/')
app = Flask(__name__, static_folder=static_path, static_url_path='/')

@app.route('/', methods=['GET'])
def index():
    files = get_list()
    return render_template('index.html', files=files)

@app.route('/upload', methods=['POST'])
def upload():
    file = request.files.get('upfile', None)
    if not file:
        return '선택된 파일이 없습니다.'
    logFile = path.join(static_path, file.filename)
    file.save(logFile)
    counter = StatusCounter(logFile)
    save_image([item for item in counter], './resources/status.jpg')
    return redirect(url_for('index'))


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80, debug=True)


