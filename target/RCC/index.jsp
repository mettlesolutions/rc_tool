<html>
<head>
	<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
	<title>RC CLIENT APP</title>
</head>
    <body>    
       <h1>RCCLIENT APPLICATION</h1>
        <div style="margin: 20px; margin-left: 40px">
        <form action="http://localhost:8080/RCC/call/upload/" method="POST" enctype="multipart/form-data">
            <label>First Name</label>
            <input type="text" name="firstName" id="firstName" value="Siva" placeholder="First Name" required>
            <label>Last Name</label>
            <input type="text" name="lastName" id="lastName" value="Abhishek" placeholder="Last Name" required>
            <label>Address</label>
            <input type="text"  name="address" id="address" value="101 asdasd3 11" placeholder="Address" required>
            <label>City</label>
            <input type="text" name="city" id="city" value="Tempe" placeholder="City" required>
            <label>State</label>
            <input type="text" name="state" id="state" value="Az" placeholder="State" required>
            <label>Zipcode</label>
            <input type="text" name="zipCode" id="zipCode" value="12333" placeholder="Zipcode" required>
            <label>Phone</label>
            <input type="text" name="phone" id="phone" value="4804800000" placeholder="Phone Number" required>
            <label>Case ID</label>
            <input type="text" name="caseID" id="caseID" value="12345" placeholder="Case ID" required>
            <label>Letter Date</label>
            <input type="date" name="letterDate" id="letterDate" value="01-01-2019" placeholder="Letter Date" required>
            <label>Program Name</label>
            <input type="text" name="programName" id="programName" value="esmd" placeholder="Program Name" required>
            <label>HIPPS Code</label>
            <input type="text" name="hippsCode" id="hippsCode" value="hips" placeholder="HIPPS Code" required>
            <label>Claim ID</label>
            <input type="text"  name="claimID" id="claimID" value="1234567890123" placeholder="Claim ID" required>
            <label>Comments</label>
            <input type="text" name="comments" id="comments" value="comments...."  placeholder="Comments" required>
            <label>Date of Birth</label>
            <input type="date" name="dateOfBirth" id="dateOfBirth" value="01-01-1956" placeholder="Date of Birth" required>
            <label>Date of Service</label>
            <input type="date"  name="dateOfService" id="dateOfService" value="01-01-2019" placeholder="Date of Service" required>
            <label>Subscriber ID</label>
            <input type="text" name="subscriberID"  id="subscriberID" value="1234567" placeholder="Subscriber ID" required>
            <label>Procedure Code</label>
            <input type="text" name="procedureCode" id="procedureCode" value="abcdef" placeholder="Procedure Code" required>
            <label>Letter ID</label>
            <input type="text"  name="letterID" id="letterID" value="B7MH9DOFCBNDK68YVXOAFWXYD" placeholder="Letter ID" required>
            <label>Select Filetype </label>
            <select name="fileType" id="fileType" required>
            <option>pdf</option>
            <option>doc</option>
            <option>docx</option>
            </select>
            <label>Upload File</label>
            <input type="hidden" name="fileName" id="fileName" value="ups">
            <input type="file" name="selectedFile" id="selectedFile" required>
            <input type="submit">
        </form>
        </div>
    </body>
</html>