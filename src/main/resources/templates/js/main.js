// Lấy tham chiếu đến các nút
var createCourseBtn = document.getElementById("create-course-btn");
var resetBtn = document.getElementById("reset-btn");

// Gắn kết sự kiện click cho nút "Tạo khóa học"
createCourseBtn.addEventListener("click", function() {
  // Xử lý logic khi nhấp vào nút "Tạo khóa học" ở đây
  console.log("Nút 'Tạo khóa học' đã được nhấp");
});

// Gắn kết sự kiện click cho nút "Reset"
resetBtn.addEventListener("click", function() {
  // Xử lý logic khi nhấp vào nút "Reset" ở đây
  console.log("Nút 'Reset' đã được nhấp");
});
function addCourse() {
  var table = document.getElementById("course-table");
  var nameInput = document.getElementById("course-name");
  var typeInput = document.getElementById("course-type");
  var topicInput = document.getElementById("course-topic");
  
  var rowCount = table.rows.length;
  var row = table.insertRow(rowCount);
  
  var cell1 = row.insertCell(0);
  cell1.innerHTML = rowCount;
  
  var cell2 = row.insertCell(1);
  cell2.innerHTML = nameInput.value;
  
  var cell3 = row.insertCell(2);
  cell3.innerHTML = typeInput.value;
  
  var cell4 = row.insertCell(3);
  cell4.innerHTML = topicInput.value;
  
  nameInput.value = "";
  typeInput.value = "";
  topicInput.value = "";
}