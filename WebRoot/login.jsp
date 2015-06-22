<%@ page contentType="text/html; charset=UTF-8" %>
<%
	session.removeAttribute("userInfo");
%>

<html>
<head>
<title>TUWA-IE网站后台管理</title>
<script type="text/javascript">
		function check(){
			var logincode = document.getElementById("logincode").value;
			var password = document.getElementById("password").value;
			var error = document.getElementById("error");
			error.innerHTML="";
			if(logincode==""){
				error.innerHTML="用户名不能为空！";
				return false;
			}
			if(password==""){
				error.innerHTML="密码不能为空！";
				return false;
			}
			return true;
		}
	</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE3 {color: #528311; font-size: 12px; }
.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
.submit{ background:url(img/login/submit.jpg) no-repeat; cursor:hand; width:40px; height:22px; border:0;}
.reset{ background:url(img/login/reset.jpg) no-repeat; cursor:hand; width:41px; height:22px; border:0;}
-->
</style></head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#e5f6cf">&nbsp;</td>
  </tr>
  <tr>
    <td height="608" background="img/login/login_03.gif"><table width="862" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="266" background="img/login/login_04.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="95"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="424" height="95" background="img/login/login_06.gif">&nbsp;</td>
            <td width="183" background="img/login/login_07.gif">
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <form action="user_login.do" method="post" >
              <tr>
                <td width="21%" height="30"><div align="center"><span class="STYLE3">用户</span></div></td>
                <td width="79%" height="30"><input type="text" name="logincode"  style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;"></td>
              </tr>
              <tr>
                <td height="30"><div align="center"><span class="STYLE3">密码</span></div></td>
                <td height="30"><input type="password" name="password"  style="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;"></td>
              </tr>
              <tr>
                <td height="30">&nbsp;</td>
                <td height="30"><input type="submit" name="submit" value="" onclick="return check()" class="submit"/><input name="reset" type="reset" value="" class="reset" /></td>
              </tr>
              </form>
            </table>
             
            </td>
            <td width="255" background="img/login/login_08.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="247" valign="top" background="img/login/login_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="22%" height="30">&nbsp;</td>
            <td width="56%">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
            		<tr>
            			<td width="48%">&nbsp;</td>
            			<td width="42%" align="center"><font id="error" size="2" color="red">${error}&nbsp;</font></td>
            			<td width="10">&nbsp;</td>
            		</tr>
            	</table>
            </td>
            <td width="22%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="44%" height="20">&nbsp;</td>
                <td width="56%" class="STYLE4">TUWA-IE后台管理2014V1.0 </td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#a2d962">&nbsp;</td>
  </tr>
</table>

</html>
