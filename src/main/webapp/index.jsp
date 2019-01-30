<html>
<head>

	<title>RC CLIENT APP</title>
</head>
    <body>    
       <h1>RCCLIENT APPLICATION</h1>
        <div style="margin: 20px; margin-left: 40px">
        <form action="http://localhost:8080/RCC/call/upload/" method="post" enctype="multipart/form-data">
            <label>First Name</label>
            <input type="text" name="firstName" value="Siva" placeholder="First Name">
            <label>Last Name</label>
            <input type="text" name="lastName" value="Abhishek" placeholder="Last Name">
            <label>Address</label>
            <input type="text"  name="address" value="101 asdasd3 11" placeholder="Address">
            <label>City</label>
            <input type="text" name="city"value="Tempe" placeholder="City">
            <label>State</label>
            <input type="text" name="state" value="Az" placeholder="State">
            <label>Zipcode</label>
            <input type="text" name="zipCode" value="12333" placeholder="Zipcode">
            <label>Phone</label>
            <input type="text" name="phone" value="4804800000" placeholder="Phone Number">
            <label>Case ID</label>
            <input type="text" name="caseID" value="12345" placeholder="Case ID">
            <label>Letter Date</label>
            <input type="date" name="letterDate" value="01-01-2019" placeholder="Letter Date">
            <label>Program Name</label>
            <input type="text" name="programName" value="esmd" placeholder="Program Name">
            <label>HIPPS Code</label>
            <input type="text" name="hippsCode" value="hips" placeholder="HIPPS Code">
            <label>Claim ID</label>
            <input type="text"  name="claimID" value="1234567890123" placeholder="Claim ID">
            <label>Comments</label>
            <input type="text" name="comments" value="comments...."  placeholder="Comments">
            <label>Date of Birth</label>
            <input type="date" name="dateOfBirth" value="01-01-1956" placeholder="Date of Birth">
            <label>Date of Service</label>
            <input type="date"  name="dateOfService" value="01-01-2019" placeholder="Date of Service">
            <label>Subscriber ID</label>
            <input type="text" name="subscriberID" value="1234567" placeholder="Subscriber ID">
            <label>Procedure Code</label>
            <input type="text" name="procedureCode" value="abcdef" placeholder="Procedure Code">
            <label>Letter ID</label>
            <input type="text"  name="letterID"  value="B7MH9DOFCBNDK68YVXOAFWXYD" placeholder="Letter ID">
            <label>Upload File</label>
            <input type="file" name="selectedFile">
        	<input type="submit" value="Submit">
        </form>
        </div>
    </body>
</html>