var mysql = require("mysql2");

var db_info = {
  host: "localhost", //DB주소
  port: "3306", //포트
  user: "root", //계정이름
  password: "inhatc", //비밀번호
  database: "node_board", //DB
};

module.exports = {
  init: function () {
    return mysql.createConnection(db_info);
  },
  connect: function (conn) {
    conn.connect(function (err) {
      if (err) console.error("mysql connection error:" + err);
      else console.log("mysql is connected successfully!");
    });
  },
};
