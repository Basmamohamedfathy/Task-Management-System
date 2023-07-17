/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagmentsystemfinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DELL
 */
public class Database {

    public ResultSet Login(String username, String password) {
        ResultSet result = null;
        try {
            String query = "SELECT * from login where[username]='" + username + "' and[password]='" + password + "'";
            DatabaseFunction db = new DatabaseFunction();
            result = db.ExecuteDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
        return result;
    }

    public ResultSet LoginWithUser(String username) {
        ResultSet result = null;
        try {
            String query = "SELECT * from login where[username]='" + username + "'";
            DatabaseFunction db = new DatabaseFunction();
            result = db.ExecuteDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
        return result;
    }

    public boolean AddUser(String username, String password, String role) {
        boolean ret = false;
        try {
            String query = "insert into login(username,password,role) values('" + username + "','" + password + "','" + role + "')";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean DeleteUser(String username) {
        boolean ret = false;
        try {
            String query = "DELETE from login WHERE [username]='" + username + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean UpdateUser(String username, String password, String role) {
        boolean ret = false;
        try {
            String query = "Update Login set password = '" + password + "' , role = '" + role + "' where username = '" + username + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean CheckEmployee(String username) {

        boolean ret = false;
        try {
            DatabaseFunction db = new DatabaseFunction();
            Connection con = db.getconnection();
            String query = "SELECT * from login where[username]='" + username + "'and [role]='E'";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            if (result != null) {
                if (result.next()) {
                    ret = true;
                }
            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;

    }

    public boolean AddEmployee(String username, String name, String position, String vacation) {
        boolean ret = false;
        try {
            String query = "insert into employee(username,name,position,vacation) values ('" + username + "','" + name + "','" + position + "','" + vacation + "')  ";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean DeleteEmployee(String username) {
        boolean ret = false;
        try {
            String query = "DELETE from employee WHERE [username]='" + username + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean DeleteProject(String id) {
        boolean ret = false;
        try {
            String query = "DELETE from projects WHERE [project_id]='" + id + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public ResultSet ValidEmployee(String username) {
        ResultSet result = null;
        try {
            String query = "SELECT * from employee where[username]='" + username + "'";
            DatabaseFunction db = new DatabaseFunction();
            result = db.ExecuteDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
        return result;
    }

    public boolean UpdateEmployee(String username, String name, String position, String vacation) {
        boolean ret = false;
        try {
            String query = "Update employee set name = '" + name + "' , position = '" + position + "',vacation = '" + vacation + "' where username = '" + username + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean AddProject(String id, String name) {
        boolean ret = false;
        try {
            String query = "insert into projects(project_id,project_name) values('" + id + "','" + name + "')";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public ResultSet checkProject(String id) {
        ResultSet result = null;
        try {
            String query = "SELECT * from projects where[project_id]='" + id + "'";
            DatabaseFunction db = new DatabaseFunction();
            result = db.ExecuteDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
        return result;
    }

    public boolean UpdateProject(String id, String name) {
        boolean ret = false;
        try {
            String query = "Update projects set project_name = '" + name + "'where project_id = '" + id + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean UpdateEmployeeType(String user, String position) {
        boolean ret = false;
        try {
            String query = "Update employee set position= '" + position + "'where username = '" + user + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean DeleteTaskPhase(String code) {
        boolean ret = false;
        try {
            String query = "update tasks set phase='  'WHERE [code]='" + code + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public ResultSet checktask(String code) {
        ResultSet result = null;
        try {
            String query = "SELECT * from tasks where[code]='" + code + "'";
            DatabaseFunction db = new DatabaseFunction();
            result = db.ExecuteDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
        return result;
    }

    public boolean UpdateTaskPhase(String code, String phase) {
        boolean ret = false;
        try {
            String query = "Update tasks set phase = '" + phase + "'  where code = '" + code + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean TimeCard(String user, String date, String from, String to) {
        boolean ret = false;
        try {
            String query = "insert into attendence(username,date,attend,departure) values ('" + user + "','" + date + "','" + from + "','" + to + "')  ";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean UpdateApproval(String code, String approval) {
        boolean ret = false;
        try {
            String query = "Update permission set approval = '" + approval + "'  where code = '" + code + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean ApproveLeave(String code, String approval) {
        boolean ret = false;
        try {
            String query = "Update leave set approval = '" + approval + "'  where code = '" + code + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean createpermission(String user, String date, String from, String to) {
        boolean ret = false;
        try {
            String query = "insert into permission(username,date_creation,from_time ,to_time,approval) values ('" + user + "','" + date + "','" + from + "','" + to + "','NEW ') ";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean createleave(String user, String date, String from, String to, String type) {
        boolean ret = false;
        try {
            String query = "insert into leave(username,date_creation,leave_type,leave_date_from,leave_date_to,approval) values ('" + user + "','" + date + "','" + type + "','" + from + "','" + to + "','NEW ') ";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public void DisplayPermission(JTable x, String y) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM permission where username='" + y + "'";
            DatabaseFunction db = new DatabaseFunction();
            rs = db.ExecuteDatabaseQuery(query);
            x.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            rs = null;
        }
    }

    public void DisplayLeave(JTable x, String y) {
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM leave where username='" + y + "'";
            DatabaseFunction db = new DatabaseFunction();
            rs = db.ExecuteDatabaseQuery(query);
            x.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());

        }
    }

    public void calendar(JTable x) {
        ResultSet result = null;
        try {
            String query = "SELECT code,title,start_date,end_date,estimation_hour,phase From tasks";
            DatabaseFunction db = new DatabaseFunction();
            result = db.ExecuteDatabaseQuery(query);;
            x.setModel(DbUtils.resultSetToTableModel(result));

        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
    }

    public void display(JTable x, String y) {
        ResultSet result = null;
        try {
            String query = "SELECT * From tasks  where assigned_employee='" + y + "'";
            DatabaseFunction db = new DatabaseFunction();
            result = db.ExecuteDatabaseQuery(query);
            x.setModel(DbUtils.resultSetToTableModel(result));

        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }

    }

    public boolean ValidTask(String code, String user) {
        boolean ret = false;
        try {
            DatabaseFunction db = new DatabaseFunction();
            Connection con = db.getconnection();
            String query = "SELECT * from tasks where[code]='" + code + "'and employee='" + user + "'";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            if (result != null) {
                if (result.next()) {
                    ret = true;
                }
            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean createTaskLog(String user, String code, String date, String from, String to) {
        boolean ret = false;
        try {

            String query = "insert into task_log(code,username,date,from_time ,to_time,evalution) values ('" + code + "','" + user + "','" + date + "','" + from + "','" + to + "','no evalution') ";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public void taskslogDisplay(JTable x) {
        ResultSet result = null;
        try {
            DatabaseFunction db = new DatabaseFunction();
            String query = "SELECT * From task_log";
            result = db.ExecuteDatabaseQuery(query);
            x.setModel(DbUtils.resultSetToTableModel(result));

        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
    }

    public boolean CreateTask(String code1, String title1, String description1, String assignedfor1, String phase1, String projectid1, String priority1, String creatorname1, String start1, String end1, String estimation1) {
        boolean ret = false;
        try {
            String query = "SET IDENTITY_INSERT tasks ON insert into tasks"
                    + "(code,title,description,employee,phase,project,priorty"
                    + ",creator_name,start_date,end_date,estimation_hour) "
                    + "values('" + code1 + "','" + title1 + "','" + description1 + "','" + assignedfor1 + "',"
                    + "'" + phase1 + "','" + projectid1 + "','" + priority1 + "','" + creatorname1 + "','"
                    + "" + start1 + "','" + end1 + "','" + estimation1 + "')SET IDENTITY_INSERT tasks OFF";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean UpdateTask(String code1, String title1, String description1, String assignedfor1, String phase1, String priority1, String creatorname1, String start1, String end1, String estimation1) {
        boolean ret = false;
        try {
            String query = "UPDATE tasks SET title = '" + title1 + "',description = '" + description1 + "',"
                    + "employee = '" + assignedfor1 + "',phase = '" + phase1 + "',priorty = '" + priority1 + "',creator_name = '" + creatorname1 + "',"
                    + "start_date = '" + start1 + "',end_date = '" + end1 + "',estimation_hour = '" + estimation1 + "' WHERE code='" + code1 + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public boolean Updateevaluation(String code, String evaluation) {
        boolean ret = false;
        try {
            String query = "UPDATE task_log set evalution ='" + evaluation + "'where code='" + code + "'";
            DatabaseFunction db = new DatabaseFunction();
            ret = db.UpdateDatabaseQuery(query);
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }
 

}
