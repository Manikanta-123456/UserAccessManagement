<!-- Loop through pending requests and display them -->
<form action="ApprovalServlet" method="post">
    <input type="hidden" name="requestId" value="request_id">
    <button name="action" value="Approved">Approve</button>
    <button name="action" value="Rejected">Reject</button>
</form>
