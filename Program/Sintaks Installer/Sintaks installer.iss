[Setup]
AppName=Inventory Prangko dan Filateli
AppVerName=Inventory Prangko dan Filateli
DefaultGroupName=Inventory Prangko dan Filateli
AppPublisher=L.G.O. Systems
AppVersion=1.0
AllowNoIcons=false
AppCopyright=
PrivilegesRequired=admin
; Este es el nombre del archivo exe que se va a generar
OutputBaseFilename=SetupInventoryPrangkoDanFilateli
; Esta es la carpeta de instalación por defecto. OJO: {pf} es una variable propia de
; innosetup y significa la carpeta de Archivos de programa (o Program files si es
; un windows en inglés)
DefaultDirName={pf}\Inventory Prangko dan Filateli
[Languages]
Name: "en"; MessagesFile: "compiler:Languages\Indonesian.isl"

[Tasks]
; Esto no se toca. Es la indicación para innosetup de que debe crear los íconos necesarios
; para iniciar el programa y para desinstalarlo
Name: desktopicon; Description: Create a &desktop icon; GroupDescription: Additional icons:

[Files]
; OJO: antes que todo. Los parámetros: regserver restartreplace shared file, etc. son
; parámetros que tienen que ir tal y como aparecen acá. Cuesta un poco comprenderlos.
; Por ahora los dejamos tal y como están acá.
; Otra cosa: {sys} = carpeta system de windows
;            {win} = carpeta windows de windows
;            {cf} = carpeta archivos comunes de windows
;            {tmp} = carpeta temporal de windows
;            {app} = carpeta donde se va a instalar el programa (fue definida arriba en el parámetro: DefaultDirName=
; -------------------------------------------------------------------------------------
; Aquí van los archivos de la aplicación: el .exe y otros que ocupe el programa
Source: C:\Users\reyha\OneDrive\Desktop\aplikasi_iventory_pos\SistemInformasiGudang\dist\Inventory Prangko dan Filateli.exe; DestDir: {app}; Flags: ignoreversion
Source: C:\Users\reyha\OneDrive\Desktop\aplikasi_iventory_pos\SistemInformasiGudang\dist\*; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
;Source: C:\Users\reyha\OneDrive\Desktop\aplikasi_iventory_pos\SistemInformasiGudang\db_inventory_pos.sql*; DestDir: {tmp}; Flags : ignoreversion deleteafterinstall


[INI]

[Icons]
; Estos son los íconos que el instalador va a crear en el grupo de programas.
; Aquí se incluye: el ícono para abrir el programa, el ícono para desinstalar el programa
; y el ícono que se ubica en el escritorio
; OJO: {group} = nombre del grupo de programa que se definió arriba en el parámetro: DefaultGroupName=
Name: {group}\Inventory Prangko dan Filateli; Filename: {app}\Inventory Prangko dan Filateli.exe; WorkingDir: {app}; IconIndex: 0
Name: {group}\Uninstall Inventory Prangko dan Filateli; Filename: {uninstallexe}
Name: {userdesktop}\Inventory Prangko dan Filateli; Filename: {app}\Inventory Prangko dan Filateli.exe; Tasks: desktopicon; WorkingDir: {app}; IconIndex: 0


[Run]
; OJO: yo tengo una carpeta llamada complementos en donde tengo el instalador del Net Framework 2.0 y el MSI del driver de MyODBC
; Esta línea ejecuta silenciosamente el instalador del Microsoft Net Framework 2.0
Filename: {src}\Software Pendukung\jre-8u161-windows-i586.exe; Parameters: "/s"; WorkingDir: {src}\Software Pendukung; Description: jre-8u161-windows-i586; StatusMsg: Menginstal JRE 32 bit; Flags: runhidden

; Esta línea ejecuta el driver de MyODBC
Filename: msiexec; Parameters: /i mysql-connector-odbc-5.2.4-ansi-win32.msi /qn; WorkingDir: {src}\Software Pendukung; StatusMsg: Menginstal Driver Database; Description: Menginstal Driver Database; Flags: runhidden

; Instalamos MySQL 5 en modo desatendido y silencioso
Filename: msiexec; Parameters: "/i mysql-essential-5.0.45-win32.msi /qn INSTALLDIR=""C:\mysql"""; WorkingDir: {src}\Software Pendukung; StatusMsg: Memasang Database Engine; Description: Memasang Database Engine; Flags: runhidden
; Instalamos el servicio de MySQL
;C:\mysql\bin\
Filename: C:\mysql\bin\mysqld-nt.exe; Parameters: --install; WorkingDir: C:\mysql\bin; StatusMsg: Menginstal Layanan MySQL; Description: Menginstal Layanan MySQL; Flags: runhidden
; Levantamos el servicio de MySQL en Windows 
Filename: net.exe; Parameters: start mysql; StatusMsg: Memulai Layanan MySQL; Description: Mulai Layanan MySQL; Flags: runhidden
; Insertamos al usuario micelanea
;Filename: C:\mysql\bin\mysql.exe; Parameters: "-e ""insert into mysql.user(host,user,password) values ('%','radp',PASSWORD('123'));"" -u root"; WorkingDir: {tmp}; StatusMsg: Mengkonfigurasi Database Server Membuat User; Flags: runhidden
;Esto me permite crear la base de datos
;Filename: C:\mysql\bin\mysql.exe; Parameters: "-u root -h localhost -e ""create database db_inventory_pos";  WorkingDir: {tmp}; StatusMsg: Membuat Database; Flags: runhidden
; Le damos todos los privilegios al usuario micelanea del localhost
;Filename: C:\mysql\bin\mysql.exe; Parameters: "-e ""grant all privileges on db_inventory_pos.* to 'radp'@'%';"" -u root"; WorkingDir: {tmp}; StatusMsg: Mengkonfigurasi Server Database Menugaskan hak istimewa; Flags: runhidden
; Flusheamos los privilegios
;Filename: C:\mysql\bin\mysql.exe; Parameters: "-e ""flush privileges;"" -u root"; WorkingDir: {tmp}; StatusMsg: Mengkonfigurasi hak istimewa Database Server Flashing; Flags: runhidden
;cargamos la base de datos
;Filename: C:\mysql\bin\mysql.exe; Parameters: "-u root -h localhost -e ""use db_inventory_pos; source db_inventory_pos.sql;";  WorkingDir: {tmp}; StatusMsg: Membuat Database; Flags: runhidden
Filename: {app}\Inventory Prangko dan Filateli.exe; Description: Run Application; Flags: postinstall shellexec skipifsilent nowait; 

;[UninstallRun]
;Filename: msiexec.exe; Parameters: "/x ""{app}\mysql-connector-odbc-5.2.4-ansi-win32.msi"""
;Filename: msiexec.exe; Parameters: "/x ""{app}\mysql-essential-5.0.45-win32.msi"""


[Messages]
; Estos mensajes simplemente son un override de los mensajes de Innosetup ya que vienen
; en inglés.
WelcomeLabel1=Instalasi point of sale Inventory Prangko dan Filateli
WelcomeLabel2=Proses ini akan menginstall point of sale Inventory Prangko dan Filateli.%n%nDianjurkan untuk menutup semua aplikasi yang terbuka%nsebelum melanjutkan.