from flask import Flask, render_template, json, request, redirect
from flask.ext.mysql import MySQL
from flask import session


mysql = MySQL()
app = Flask(__name__)

# MySQL configurations
app.config['MYSQL_DATABASE_USER'] = 'cmpe281'
app.config['MYSQL_DATABASE_PASSWORD'] = 'root1234'
app.config['MYSQL_DATABASE_DB'] = 'test'
app.config['MYSQL_DATABASE_HOST'] = 'mydbinstance.cnqobngvit0z.us-west-2.rds.amazonaws.com'
mysql.init_app(app)


@app.route('/')
def main():
    return render_template('test.html')


@app.route('/showSignUp')
def showSignUp():
    return render_template('signup.html')

@app.route('/showSignin')
def showSignin():
    return render_template('signin.html')

@app.route('/showProject')
def showProject():
    return render_template('Project1.html')

@app.route('/showTestCase')
def showTestCase():
    return render_template('TestCaseDetails.html')

@app.route('/showBugs')
def showBugs():
    return render_template('BugDetails.html')

@app.route('/showReports')
def showReports():
    return render_template('Reoprts.html')

@app.route('/showIndex')
def showIndex():
    count = countTesters()
    countTC = countTestCases()
    countB = countBugs()
    return render_template('index.html', count=count, tcCount=countTC, bCount=countB)

def countTesters():
    try:
        con = mysql.connect()
        cursor = con.cursor()

        query = ("SELECT count(*) FROM userinfo ")

        cursor.execute(query)

        for row in cursor.fetchall():
            user1 = row[0]

        print user1
        print "user1"
        return user1
    except Exception as e:
        return json.dumps({'error': str(e)})
    finally:
        cursor.close()
        con.close()

def countTestCases():
    try:
        con = mysql.connect()
        cursor = con.cursor()

        query = ("SELECT count(*) FROM TestCaseDetails ")

        cursor.execute(query)

        for row in cursor.fetchall():
            user1 = row[0]

        print user1
        print "user1"
        return user1
    except Exception as e:
        return json.dumps({'error': str(e)})
    finally:
        cursor.close()
        con.close()

def countBugs():
    try:
        con = mysql.connect()
        cursor = con.cursor()

        query = ("SELECT count(*) FROM BugDetails ")

        cursor.execute(query)

        for row in cursor.fetchall():
            user1 = row[0]

        print user1
        print "user1"
        return user1
    except Exception as e:
        return json.dumps({'error': str(e)})
    finally:
        cursor.close()
        con.close()


@app.route('/bugsInput', methods=['POST', 'GET'])
def bugsInput():
    try:
        print "---------Inside bugsInput------"
        print "ABCD"
        _ProjectNameB = request.form['ProjectNameB']
        _BugId = request.form['BugId']
        _TestCaseId = request.form['TestCaseIdB']
        _IssueType = request.form['IssueType']
        _Summary = request.form['Summary']
        _PriorityB = request.form['PriorityB']
        _CommentB = request.form['CommentB']
        _Description = request.form['Description']
        _AssignedBy = request.form['AssignedBy']
        _AssignedTo = request.form['AssignedTo']
        _Stepstoreproduce = request.form['Stepstoreproduce']
        _Status = request.form['Status']

        # validate the received values
        print "ABCD"
        print _ProjectNameB
        if _ProjectNameB:
            conn = mysql.connect()
            cursor = conn.cursor()

            query3 = ("insert into BugDetails "
                      "(ProjectName,BugId,TestCaseId,IssueType,Summary,PriorityB,CommentB,Description,AssignedBy,AssignedTo,Stepstoreproduce,Status)"
             "values (%s, %s, %s, %s,%s, %s, %s, %s,%s, %s, %s, %s)")

            data_query3 = (_ProjectNameB,_BugId,_TestCaseId,_IssueType,_Summary,_PriorityB,_CommentB,_Description,_AssignedBy,_AssignedTo,_Stepstoreproduce,_Status)
            cursor.execute(query3, data_query3)
            cursor.execute("commit")

            count = countTesters()
            countTC = countTestCases()
            countB = countBugs()
            return render_template('index.html', count=count, tcCount=countTC, bCount=countB)
    except Exception as e:
        return json.dumps({'error': str(e)})
    finally:
        cursor.close()
        conn.close()

@app.route('/signUp', methods=['POST', 'GET'])
def signUp():
    try:
        _name = request.form['inputName']
        _email = request.form['inputEmail']
        _password = request.form['inputPassword']

        # validate the received values
        if _name and _email and _password:

            # All Good, let's call MySQL

            conn = mysql.connect()
            cursor = conn.cursor()

            cursor.callproc('sp_createUser', (_name, _email, _password))
            data = cursor.fetchall()

            if len(data) is 0:
                conn.commit()
                return json.dumps({'message': 'User created successfully !'})
            else:
                return json.dumps({'error': str(data[0])})
        else:
            return json.dumps({'html': '<span>Enter the required fields</span>'})

    except Exception as e:
        return json.dumps({'error': str(e)})
    finally:
        cursor.close()
        conn.close()


@app.route('/testCaseInputs', methods=['POST', 'GET'])
def testCaseInput():
    try:
        print "---------Inside createTestCase------"
        _ProjectName = request.form['ProjectName']
        _TestCaseID = request.form['TestCaseID']
        _TestCaseName = request.form['TestCaseName']
        _ScenarioName = request.form['ScenarioName']
        _Prerequisite = request.form['Prerequisite']
        _TestCaseDescription = request.form['TestCaseDescription']
        _StepsDescription = request.form['StepsDescription']
        _ExpectedResult = request.form['ExpectedResult']
        _ActualResult = request.form['ActualResult']
        _RequirementId = request.form['RequirementId']
        _Type = request.form['Type']
        _Priority = request.form['Priority']
        _TestCaseDesigner = request.form['TestCaseDesigner']
        _Comment = request.form['Comment']

        print _ProjectName
        # validate the received values
        if _ProjectName:
            conn = mysql.connect()
            cursor = conn.cursor()


            query2 = ("insert into TestCaseDetails "
                      "(ProjectName, TestCaseID, TestCaseName,ScenarioName,Prerequisite,TestCaseDescription,StepsDescription,ExpectedResult,ActualResult,RequirementId,Type,Priority,TestCaseDesigner,Comment)"
             "values (%s, %s, %s, %s,%s, %s, %s, %s,%s, %s, %s, %s,%s, %s)")

            data_query2 = (_ProjectName,_TestCaseID,_TestCaseName,_ScenarioName,_Prerequisite,_TestCaseDescription,_StepsDescription,_ExpectedResult,_ActualResult,_RequirementId,_Type,_Priority,_TestCaseDesigner,_Comment)
            cursor.execute(query2, data_query2)
            cursor.execute("commit")

            count = countTesters()
            countTC = countTestCases()
            countB = countBugs()
            return render_template('index.html', count=count, tcCount=countTC, bCount=countB)
    except Exception as e:
        return json.dumps({'error': str(e)})
    finally:
        cursor.close()
        conn.close()


@app.route('/userHome')
def userHome():

    if session.get('user'):
        return
    else:
        return render_template('error.html',error = 'Unauthorized Access')


@app.route('/logout')
def logout():
    session.pop('user',None)
    return redirect('/')

@app.route('/validateLogin', methods=['POST'])
def validateLogin():
    try:
        _username = request.form['inputEmail']
        _password = request.form['inputPassword']

        # connect to mysql

        con = mysql.connect()
        cursor = con.cursor()

        query = ("SELECT * FROM userinfo "
         "WHERE username = %s")

        cursor.execute(query,_username)

        for row in cursor.fetchall():
            user1 = row[1]
            Val = row[3]

        print str(Val)
        print str(_password)
        if Val:
            if str(Val)== str(_password):
                session['user'] = user1
                count = countTesters()
                countTC = countTestCases()
                countB = countBugs()
                return render_template('index.html',count = count,tcCount = countTC,bCount = countB)
            else:
                return render_template('error.html', error='Wrong Email address or Password.')
        else:
            return render_template('error.html', error='Wrong Email address or Password.')


    except Exception as e:
        return render_template('error.html', error=str(e))
    finally:
        cursor.close()
        con.close()

if __name__ == "__main__":
    app.secret_key = 'super secret key'
    app.config['SESSION_TYPE'] = 'filesystem'
    app.run(port=5004,debug=True)
