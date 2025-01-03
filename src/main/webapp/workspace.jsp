<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Collaboration Workspace</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/4.5.4/socket.io.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <h2 class="text-center mt-4">Real-Time Collaboration Workspace</h2>
        <div class="row mt-4">
            <div class="col-md-8">
                <textarea id="codeEditor" class="form-control" rows="20" placeholder="Start coding here..." style="font-family: monospace;"></textarea>
            </div>
            <div class="col-md-4">
                <h4>Participants</h4>
                <ul id="participantsList" class="list-group">
                    <!-- Dynamically updated -->
                </ul>
            </div>
        </div>
    </div>
    <script>
        const socket = io.connect("http://localhost:3000"); // Change as needed

        const editor = document.getElementById("codeEditor");
        editor.addEventListener("input", () => {
            socket.emit("codeUpdate", editor.value);
        });

        socket.on("codeUpdate", (data) => {
            editor.value = data;
        });

        // Participants handling
        socket.on("participantsUpdate", (participants) => {
            const participantsList = document.getElementById("participantsList");
            participantsList.innerHTML = "";
            participants.forEach(participant => {
                const li = document.createElement("li");
                li.classList.add("list-group-item");
                li.textContent = participant;
                participantsList.appendChild(li);
            });
        });
       
        //
    </script>
</body>
</html>
