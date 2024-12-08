<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Join Collaboration Session</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="card mt-5">
            <div class="card-body">
                <h2 class="text-center">Join a Collaboration Session</h2>
                <form action="joinSession" method="post">
                    <div class="form-group">
                        <label>Session ID</label>
                        <input type="text" class="form-control" name="sessionId" placeholder="Enter Session ID" required />
                    </div>
                    <div class="form-group">
                        <label>Access Code</label>
                        <input type="password" class="form-control" name="accessCode" placeholder="Enter Access Code" required />
                    </div>
                    <button type="submit" class="btn btn-success">Join Session</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
