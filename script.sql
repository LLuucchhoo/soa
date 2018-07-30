USE [master]
GO
/****** Object:  Database [soabd]    Script Date: 29/07/2018 03:37:39 p.m. ******/
CREATE DATABASE [soabd]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'soabd', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\soabd.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'soabd_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\soabd_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [soabd] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [soabd].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [soabd] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [soabd] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [soabd] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [soabd] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [soabd] SET ARITHABORT OFF 
GO
ALTER DATABASE [soabd] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [soabd] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [soabd] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [soabd] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [soabd] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [soabd] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [soabd] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [soabd] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [soabd] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [soabd] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [soabd] SET  DISABLE_BROKER 
GO
ALTER DATABASE [soabd] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [soabd] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [soabd] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [soabd] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [soabd] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [soabd] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [soabd] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [soabd] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [soabd] SET  MULTI_USER 
GO
ALTER DATABASE [soabd] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [soabd] SET DB_CHAINING OFF 
GO
ALTER DATABASE [soabd] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [soabd] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [soabd]
GO
/****** Object:  User [modulo3]    Script Date: 29/07/2018 03:37:42 p.m. ******/
CREATE USER [modulo3] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[modulo3]
GO
/****** Object:  User [modulo2]    Script Date: 29/07/2018 03:37:42 p.m. ******/
CREATE USER [modulo2] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [miguel]    Script Date: 29/07/2018 03:37:42 p.m. ******/
CREATE USER [miguel] FOR LOGIN [miguel] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [miguel]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [miguel]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [miguel]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [miguel]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [miguel]
GO
ALTER ROLE [db_datareader] ADD MEMBER [miguel]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [miguel]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [miguel]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [miguel]
GO
/****** Object:  Schema [modulo3]    Script Date: 29/07/2018 03:37:43 p.m. ******/
CREATE SCHEMA [modulo3]
GO
/****** Object:  Table [dbo].[CLASE_PRODUCTO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CLASE_PRODUCTO](
	[ID_CLASE_PRODUCTO] [int] IDENTITY(1,1) NOT NULL,
	[NOMBRE_CLASE_PRODUCTO] [nvarchar](100) NOT NULL,
	[OBSERVACION_CLASE_PRODUCTO] [nvarchar](250) NULL,
 CONSTRAINT [PK_CLASE_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[ID_CLASE_PRODUCTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CLIENTE]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CLIENTE](
	[ID_CLIENTE] [int] IDENTITY(1,1) NOT NULL,
	[ID_TIPO_CLIENTE] [int] NOT NULL,
	[ID_MUNICIPIO] [int] NOT NULL,
	[NOMBRE_CLIENTE] [nvarchar](250) NOT NULL,
	[NIT_CLIENTE] [nvarchar](20) NULL,
	[DIRECCION_CLIENTE] [nvarchar](300) NULL,
	[TELEFONO_CLIENTE] [nvarchar](20) NULL,
	[OBSERVACION_CLIENTE] [nvarchar](250) NULL,
 CONSTRAINT [PK_CLIENTE] PRIMARY KEY CLUSTERED 
(
	[ID_CLIENTE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[COMPRA]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COMPRA](
	[ID_COMPRA] [int] IDENTITY(1,1) NOT NULL,
	[ID_KARDEX] [int] NOT NULL,
	[ID_PROVEEDOR] [int] NOT NULL,
 CONSTRAINT [PK_COMPRA] PRIMARY KEY CLUSTERED 
(
	[ID_COMPRA] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DEPARTAMENTO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DEPARTAMENTO](
	[ID_DEPARTAMENTO] [int] IDENTITY(1,1) NOT NULL,
	[ID_ZONA] [int] NOT NULL,
	[NOMBRE_DEPARTAMENTO] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_DEPARTAMENTO] PRIMARY KEY CLUSTERED 
(
	[ID_DEPARTAMENTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ESTADO_PRODUCTO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ESTADO_PRODUCTO](
	[ID_ESTADO_PRODUCTO] [int] IDENTITY(1,1) NOT NULL,
	[NOMBRE_ESTADO_PRODUCTO] [nvarchar](100) NULL,
	[OBSERVACION_ESTADO_PRODUCTO] [nvarchar](250) NULL,
 CONSTRAINT [PK_ESTADO_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[ID_ESTADO_PRODUCTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[EXISTENCIA_PRODUCTO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EXISTENCIA_PRODUCTO](
	[ID_EXISTENCIA_PRODUCTO] [int] IDENTITY(1,1) NOT NULL,
	[ID_PRODUCTO] [int] NOT NULL,
	[INGRESO] [int] NOT NULL,
	[EGRESO] [int] NOT NULL,
	[SALDO] [int] NOT NULL,
 CONSTRAINT [PK_EXISTENCIA_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[ID_EXISTENCIA_PRODUCTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KARDEX]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KARDEX](
	[ID_KARDEX] [int] IDENTITY(1,1) NOT NULL,
	[ID_TIPO_DOCUMENTO] [int] NULL,
	[ID_TIPO_TRANSACCION] [int] NULL,
	[TIPO_OPERACION] [nvarchar](50) NULL,
	[ID_PRODUCTO] [int] NULL,
	[FECHA] [date] NULL,
	[CANTIDAD] [int] NULL,
	[PRECIO] [decimal](18, 0) NULL,
	[COSTO_PROMEDIO] [decimal](18, 0) NULL,
 CONSTRAINT [PK_KARDEX] PRIMARY KEY CLUSTERED 
(
	[ID_KARDEX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LINEA_PRODUCTO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LINEA_PRODUCTO](
	[ID_LINEA_PRODUCTO] [int] IDENTITY(1,1) NOT NULL,
	[ID_CLASE_PRODUCTO] [int] NOT NULL,
	[NOMBRE_LINEA_PRODUCTO] [nvarchar](100) NOT NULL,
	[OBSERVACION_LINEA_PRODUCTO] [nvarchar](250) NULL,
 CONSTRAINT [PK_LINEA_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[ID_LINEA_PRODUCTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MUNICIPIO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MUNICIPIO](
	[ID_MUNICIPIO] [int] IDENTITY(1,1) NOT NULL,
	[ID_DEPARTAMENTO] [int] NOT NULL,
	[NOMBRE_MUNICIPIO] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_MUNICIPIO] PRIMARY KEY CLUSTERED 
(
	[ID_MUNICIPIO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PRODUCTO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCTO](
	[ID_PRODUCTO] [int] IDENTITY(1,1) NOT NULL,
	[ID_LINEA_PRODUCTO] [int] NOT NULL,
	[ID_ESTADO_PRODUCTO] [int] NOT NULL,
	[NO_SERIE] [nvarchar](150) NULL,
	[NOMBRE_PRODUCTO] [nvarchar](100) NOT NULL,
	[PRECIO_PRODUCTO] [decimal](18, 2) NOT NULL,
 CONSTRAINT [PK_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[ID_PRODUCTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PROVEEDOR]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PROVEEDOR](
	[ID_PROVEEDOR] [int] IDENTITY(1,1) NOT NULL,
	[NOMBRE_PROVEEDOR] [nvarchar](250) NOT NULL,
	[NIT_PROVEEDOR] [nvarchar](20) NULL,
	[OBSERVACION_PROVEEDOR] [nvarchar](250) NULL,
 CONSTRAINT [PK_PROVEEDOR] PRIMARY KEY CLUSTERED 
(
	[ID_PROVEEDOR] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[REPRESENTANTE_X_PROVEEDOR]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[REPRESENTANTE_X_PROVEEDOR](
	[ID_REPRESENTANTE_X_PROVEEDOR] [int] IDENTITY(1,1) NOT NULL,
	[ID_PROVEEDOR] [int] NOT NULL,
	[NOMBRE_REPRESENTANTE_PROVEEDOR] [nvarchar](100) NOT NULL,
	[TELEFONO_REPRESENTANTE_PROVEEDOR] [nvarchar](20) NULL,
 CONSTRAINT [PK_REPRESENTANTE_X_PROVEEDOR] PRIMARY KEY CLUSTERED 
(
	[ID_REPRESENTANTE_X_PROVEEDOR] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TIPO_CLIENTE]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_CLIENTE](
	[ID_TIPO_CLIENTE] [int] IDENTITY(1,1) NOT NULL,
	[NOMBRE_TIPO_CLIENTE] [nvarchar](50) NOT NULL,
	[DESCRIPCION_TIPO_CLIENTE] [nvarchar](250) NULL,
 CONSTRAINT [PK_TIPO_CLIENTE] PRIMARY KEY CLUSTERED 
(
	[ID_TIPO_CLIENTE] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TIPO_DOCUMENTO]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_DOCUMENTO](
	[ID_TIPO_DOCUMENTO] [int] IDENTITY(1,1) NOT NULL,
	[NOMBRE_DOCUMENTO] [nvarchar](250) NULL,
 CONSTRAINT [PK_TIPO_DOCUMENTO] PRIMARY KEY CLUSTERED 
(
	[ID_TIPO_DOCUMENTO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TIPO_TRANSACCION]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_TRANSACCION](
	[ID_TIPO_TRANSACCION] [int] IDENTITY(1,1) NOT NULL,
	[TIPO_TRANSACCION] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_TIPO_TRANSACCION] PRIMARY KEY CLUSTERED 
(
	[ID_TIPO_TRANSACCION] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[VENDEDOR]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VENDEDOR](
	[ID_VENDEDOR] [int] IDENTITY(1,1) NOT NULL,
	[ID_ZONA] [int] NULL,
	[NOMBRE_VENDEDOR] [nvarchar](100) NULL,
	[OBSERVACION_VENDEDOR] [nvarchar](250) NULL,
 CONSTRAINT [PK_VENDEDOR] PRIMARY KEY CLUSTERED 
(
	[ID_VENDEDOR] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[VENTA]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VENTA](
	[ID_VENTA] [int] IDENTITY(1,1) NOT NULL,
	[ID_KARDEX] [int] NOT NULL,
	[ID_CLIENTE] [int] NOT NULL,
 CONSTRAINT [PK_VENTA] PRIMARY KEY CLUSTERED 
(
	[ID_VENTA] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ZONA]    Script Date: 29/07/2018 03:37:43 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ZONA](
	[ID_ZONA] [int] IDENTITY(1,1) NOT NULL,
	[NOMBRE_ZONA] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_ZONA] PRIMARY KEY CLUSTERED 
(
	[ID_ZONA] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[CLIENTE]  WITH CHECK ADD  CONSTRAINT [FK_CLIENTE_MUNICIPIO] FOREIGN KEY([ID_MUNICIPIO])
REFERENCES [dbo].[MUNICIPIO] ([ID_MUNICIPIO])
GO
ALTER TABLE [dbo].[CLIENTE] CHECK CONSTRAINT [FK_CLIENTE_MUNICIPIO]
GO
ALTER TABLE [dbo].[CLIENTE]  WITH CHECK ADD  CONSTRAINT [FK_CLIENTE_TIPO_CLIENTE] FOREIGN KEY([ID_TIPO_CLIENTE])
REFERENCES [dbo].[TIPO_CLIENTE] ([ID_TIPO_CLIENTE])
GO
ALTER TABLE [dbo].[CLIENTE] CHECK CONSTRAINT [FK_CLIENTE_TIPO_CLIENTE]
GO
ALTER TABLE [dbo].[COMPRA]  WITH CHECK ADD  CONSTRAINT [FK_COMPRA_KARDEX] FOREIGN KEY([ID_KARDEX])
REFERENCES [dbo].[KARDEX] ([ID_KARDEX])
GO
ALTER TABLE [dbo].[COMPRA] CHECK CONSTRAINT [FK_COMPRA_KARDEX]
GO
ALTER TABLE [dbo].[COMPRA]  WITH CHECK ADD  CONSTRAINT [FK_COMPRA_PROVEEDOR] FOREIGN KEY([ID_PROVEEDOR])
REFERENCES [dbo].[PROVEEDOR] ([ID_PROVEEDOR])
GO
ALTER TABLE [dbo].[COMPRA] CHECK CONSTRAINT [FK_COMPRA_PROVEEDOR]
GO
ALTER TABLE [dbo].[DEPARTAMENTO]  WITH CHECK ADD  CONSTRAINT [FK_DEPARTAMENTO_ZONA] FOREIGN KEY([ID_ZONA])
REFERENCES [dbo].[ZONA] ([ID_ZONA])
GO
ALTER TABLE [dbo].[DEPARTAMENTO] CHECK CONSTRAINT [FK_DEPARTAMENTO_ZONA]
GO
ALTER TABLE [dbo].[EXISTENCIA_PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_EXISTENCIA_PRODUCTO_PRODUCTO] FOREIGN KEY([ID_PRODUCTO])
REFERENCES [dbo].[PRODUCTO] ([ID_PRODUCTO])
GO
ALTER TABLE [dbo].[EXISTENCIA_PRODUCTO] CHECK CONSTRAINT [FK_EXISTENCIA_PRODUCTO_PRODUCTO]
GO
ALTER TABLE [dbo].[KARDEX]  WITH CHECK ADD  CONSTRAINT [FK_KARDEX_PRODUCTO] FOREIGN KEY([ID_PRODUCTO])
REFERENCES [dbo].[PRODUCTO] ([ID_PRODUCTO])
GO
ALTER TABLE [dbo].[KARDEX] CHECK CONSTRAINT [FK_KARDEX_PRODUCTO]
GO
ALTER TABLE [dbo].[KARDEX]  WITH CHECK ADD  CONSTRAINT [FK_KARDEX_TIPO_DOCUMENTO] FOREIGN KEY([ID_TIPO_DOCUMENTO])
REFERENCES [dbo].[TIPO_DOCUMENTO] ([ID_TIPO_DOCUMENTO])
GO
ALTER TABLE [dbo].[KARDEX] CHECK CONSTRAINT [FK_KARDEX_TIPO_DOCUMENTO]
GO
ALTER TABLE [dbo].[KARDEX]  WITH CHECK ADD  CONSTRAINT [FK_KARDEX_TIPO_TRANSACCION] FOREIGN KEY([ID_TIPO_TRANSACCION])
REFERENCES [dbo].[TIPO_TRANSACCION] ([ID_TIPO_TRANSACCION])
GO
ALTER TABLE [dbo].[KARDEX] CHECK CONSTRAINT [FK_KARDEX_TIPO_TRANSACCION]
GO
ALTER TABLE [dbo].[LINEA_PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_LINEA_PRODUCTO_CLASE_PRODUCTO] FOREIGN KEY([ID_CLASE_PRODUCTO])
REFERENCES [dbo].[CLASE_PRODUCTO] ([ID_CLASE_PRODUCTO])
GO
ALTER TABLE [dbo].[LINEA_PRODUCTO] CHECK CONSTRAINT [FK_LINEA_PRODUCTO_CLASE_PRODUCTO]
GO
ALTER TABLE [dbo].[MUNICIPIO]  WITH CHECK ADD  CONSTRAINT [FK_MUNICIPIO_DEPARTAMENTO] FOREIGN KEY([ID_DEPARTAMENTO])
REFERENCES [dbo].[DEPARTAMENTO] ([ID_DEPARTAMENTO])
GO
ALTER TABLE [dbo].[MUNICIPIO] CHECK CONSTRAINT [FK_MUNICIPIO_DEPARTAMENTO]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_ESTADO_PRODUCTO] FOREIGN KEY([ID_ESTADO_PRODUCTO])
REFERENCES [dbo].[ESTADO_PRODUCTO] ([ID_ESTADO_PRODUCTO])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_ESTADO_PRODUCTO]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_LINEA_PRODUCTO] FOREIGN KEY([ID_LINEA_PRODUCTO])
REFERENCES [dbo].[LINEA_PRODUCTO] ([ID_LINEA_PRODUCTO])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_LINEA_PRODUCTO]
GO
ALTER TABLE [dbo].[REPRESENTANTE_X_PROVEEDOR]  WITH CHECK ADD  CONSTRAINT [FK_REPRESENTANTE_X_PROVEEDOR_PROVEEDOR] FOREIGN KEY([ID_PROVEEDOR])
REFERENCES [dbo].[PROVEEDOR] ([ID_PROVEEDOR])
GO
ALTER TABLE [dbo].[REPRESENTANTE_X_PROVEEDOR] CHECK CONSTRAINT [FK_REPRESENTANTE_X_PROVEEDOR_PROVEEDOR]
GO
ALTER TABLE [dbo].[VENDEDOR]  WITH CHECK ADD  CONSTRAINT [FK_VENDEDOR_ZONA] FOREIGN KEY([ID_ZONA])
REFERENCES [dbo].[ZONA] ([ID_ZONA])
GO
ALTER TABLE [dbo].[VENDEDOR] CHECK CONSTRAINT [FK_VENDEDOR_ZONA]
GO
ALTER TABLE [dbo].[VENTA]  WITH CHECK ADD  CONSTRAINT [FK_VENTA_CLIENTE] FOREIGN KEY([ID_CLIENTE])
REFERENCES [dbo].[CLIENTE] ([ID_CLIENTE])
GO
ALTER TABLE [dbo].[VENTA] CHECK CONSTRAINT [FK_VENTA_CLIENTE]
GO
ALTER TABLE [dbo].[VENTA]  WITH CHECK ADD  CONSTRAINT [FK_VENTA_KARDEX] FOREIGN KEY([ID_KARDEX])
REFERENCES [dbo].[KARDEX] ([ID_KARDEX])
GO
ALTER TABLE [dbo].[VENTA] CHECK CONSTRAINT [FK_VENTA_KARDEX]
GO
USE [master]
GO
ALTER DATABASE [soabd] SET  READ_WRITE 
GO
