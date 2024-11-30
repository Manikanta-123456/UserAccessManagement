<form action="RequestServlet" method="post">
    <label for="softwareId">Software:</label>
    <select name="softwareId" id="softwareId" required>
        <!-- Populate this dynamically -->
    </select>
    <label for="accessType">Access Type:</label>
    <select name="accessType" id="accessType" required>
        <option value="Read">Read</option>
        <option value="Write">Write</option>
        <option value="Admin">Admin</option>
    </select>
    <label for="reason">Reason:</label><textarea name="reason" id="reason" required></textarea>
    <button type="submit">Request Access</button>
</form>
