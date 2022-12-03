<?php

include $_SERVER['DOCUMENT_ROOT']."/database/db.php";

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);

$mysqli = mysqli_connect($hostname, $username, $password, $database);

mysqli_set_charset($mysqli, 'utf8');

