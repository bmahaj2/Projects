
IF OBJECT_ID (N'dbo.StocksPurchase', N'U') IS NOT NULL
DROP TABLE dbo.StocksPurchase;

IF OBJECT_ID(N'dbo.UserStocksRepo', N'U') IS NOT NULL
DROP TABLE dbo.UserStocksRepo;

IF OBJECT_ID(N'dbo.Watchlist', N'U') IS NOT NULL
DROP TABLE dbo.Watchlist;
--IF OBJECT_ID (N'dbo.Stocks', N'U') IS NOT NULL
--DROP TABLE dbo.Stocks;

IF OBJECT_ID (N'dbo.Users', N'U') IS NOT NULL
DROP TABLE dbo.Users;

IF OBJECT_ID(N'dbo.Questions', N'U') IS NOT NULL
DROP TABLE dbo.Questions;




CREATE TABLE Questions(
	ID INT IDENTITY(1, 1) PRIMARY KEY,
	Question NVARCHAR(256) NOT NULL
);

CREATE TABLE Users(
	ID INT IDENTITY(1, 1) PRIMARY KEY,
	UserName NVARCHAR(16) NOT NULL,
	UserPassword NVARCHAR(16) NOT NULL,
	FirstName NVARCHAR(32) NOT NULL,
	LastName NVARCHAR(32) NOT NULL,
	Email NVARCHAR(32) NOT NULL,
	Balance FLOAT NOT NULL,
	QuestionID INT NOT NULL FOREIGN KEY REFERENCES Questions(ID),
	Answer NVARCHAR(128) NOT NULL
);


CREATE TABLE Watchlist(
	ID INT IDENTITY(1, 1) PRIMARY KEY,
	UserID INT NOT NULL FOREIGN KEY REFERENCES Users(ID),
	Symbol NVARCHAR(32) NOT NULL,
	
);

--CREATE TABLE Stocks(
--	ID INT IDENTITY(1, 1) PRIMARY KEY,
--	Symbol NVARCHAR(32) NOT NULL,
--	Name NVARCHAR(64) NOT NULL,
--	IpoYear INT,
--	Sector NVARCHAR(64),
--	Industry NVARCHAR(64)
--);

CREATE TABLE UserStocksRepo(
	ID INT IDENTITY(1, 1) PRIMARY KEY,
	StockID INT NOT NULL FOREIGN KEY REFERENCES Stocks(ID),
	UserID INT NOT NULL FOREIGN KEY REFERENCES Users(ID),
	Qty INT NOT NULL,
	TotalInvestment FLOAT NOT NULL
);

CREATE TABLE StocksPurchase(
	ID INT IDENTITY(1, 1) PRIMARY KEY,
	UserID INT NOT NULL FOREIGN KEY REFERENCES Users(ID),
	StockID INT NOT NULL,
	PurchasePrice FLOAT NOT NULL,
	PurchaseDate DATE NOT NULL,
	NumStocks INT NOT NULL,
	TransType NVARCHAR(16) NOT NULL
);


INSERT INTO Questions (Question) VALUES('What was your first car''s make and model name?');
INSERT INTO Questions (Question) VALUES('What is your mother''s madden name?');
INSERT INTO Questions (Question) VALUES('What is the name of city you were married?');
INSERT INTO Questions (Question) VALUES('What is the name of your first pet?');
INSERT INTO Questions (Question) VALUES('What is the name of your childhood best friend?');

INSERT INTO Users (UserName, UserPassword, FirstName, LastName, Email, Balance, QuestionID, Answer) 
		VALUES('admin', '1234', 'John', 'Bell', 'bell@uic.edu', 999.99, 1, 'Ford Mustang');

-- Drop procedure if already exist
--IF OBJECT_ID('[dbo].[CreateBulkSymbols]') IS NOT NULL
--DROP PROCEDURE dbo.CreateBulkSymbols;
--GO

--Create Procedure CreateBulkSymbols
--@bulk_command NVARCHAR(1000)
--AS
--BEGIN
--	IF OBJECT_ID (N'dbo.TempStocks', N'U') IS NOT NULL
--	DROP TABLE dbo.TempStocks;
--	CREATE TABLE TempStocks(
--		Symbol NVARCHAR(16),
--		Name NVARCHAR(64),
--		IPOyear INT,
--		Sector NVARCHAR(128),
--		industry NVARCHAR(128)
--	);
--	DECLARE @bulk_cmd NVARCHAR(1000);
--	SET @bulk_cmd = '	
--							BULK INSERT dbo.TempStocks
--							FROM "'+@bulk_command+'"
--							WITH
--							(
--							  FIRSTROW =2,
--							  FIELDTERMINATOR ='','',
--							  ROWTERMINATOR =''\n''
							  
--							)
--							'

--	EXEC(@bulk_cmd);
--	INSERT INTO Stocks (Symbol, Name, IpoYear, Sector, Industry) SELECT Symbol, Name, IPOyear, Sector, industry FROM TempStocks;
--	IF OBJECT_ID (N'dbo.TempStocks', N'U') IS NOT NULL
--	DROP TABLE dbo.TempStocks;
--END 
--GO

                        UPDATE UserStocksRepo SET Qty=0, TotalInvestment=0.0 
                               WHERE StockID=7 AND UserID=1;