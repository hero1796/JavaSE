USE [footballleague]
GO
/****** Object:  Table [dbo].[tblMatch]    Script Date: 06/10/2017 3:53:32 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMatch](
	[id] [int] NOT NULL,
	[date] [date] NULL,
	[idRound] [int] NULL,
	[idHomeTeam] [int] NULL,
	[idClientTeam] [int] NULL,
 CONSTRAINT [PK_tblMatch] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPlayer]    Script Date: 06/10/2017 3:53:32 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblPlayer](
	[id] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[dob] [date] NULL,
	[weight] [float] NULL,
	[height] [float] NULL,
	[idTeam] [int] NULL,
 CONSTRAINT [PK_tblPlayer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblRound]    Script Date: 06/10/2017 3:53:32 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblRound](
	[id] [int] NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_tblRound] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblTeam]    Script Date: 06/10/2017 3:53:32 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblTeam](
	[id] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[address] [varchar](50) NULL,
	[stadium] [varchar](50) NULL,
 CONSTRAINT [PK_tblTeam] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblPlayer] ([id], [name], [dob], [weight], [height], [idTeam]) VALUES (1, N'Player 1', CAST(N'1996-01-01' AS Date), 71.5, 174, 1)
INSERT [dbo].[tblPlayer] ([id], [name], [dob], [weight], [height], [idTeam]) VALUES (2, N'Player 2', CAST(N'1996-01-02' AS Date), 79.1, 170, 1)
INSERT [dbo].[tblPlayer] ([id], [name], [dob], [weight], [height], [idTeam]) VALUES (3, N'Player 3', CAST(N'1996-01-03' AS Date), 89.3, 180, 1)
INSERT [dbo].[tblRound] ([id], [name]) VALUES (1, N'round 1')
INSERT [dbo].[tblRound] ([id], [name]) VALUES (2, N'round 2')
INSERT [dbo].[tblRound] ([id], [name]) VALUES (3, N'round 3')
INSERT [dbo].[tblRound] ([id], [name]) VALUES (4, N'round 4')
INSERT [dbo].[tblRound] ([id], [name]) VALUES (5, NULL)
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (1, N'Team 1', N'Ha Noi 1', N'Stadium 1')
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (2, N'Team 2', N'Ha Noi 2', N'Stadium 2')
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (3, N'Team 3', N'Ha Noi 3', N'Stadium 3')
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (4, N'Team 4', N'Ha Noi 4', N'Stadium 4')
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (5, N'Team 5', N'Ha Noi 5', N'Stadium 5')
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (6, N'Team 6', N'Ha Noi 6', N'Stadium 6')
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (7, N'Team 7', N'Ha Noi 7', N'Stadium 7')
INSERT [dbo].[tblTeam] ([id], [name], [address], [stadium]) VALUES (8, N'Team 8', N'Ha Noi 8', NULL)
ALTER TABLE [dbo].[tblMatch]  WITH CHECK ADD  CONSTRAINT [FK_tblMatch_tblRound] FOREIGN KEY([idRound])
REFERENCES [dbo].[tblRound] ([id])
GO
ALTER TABLE [dbo].[tblMatch] CHECK CONSTRAINT [FK_tblMatch_tblRound]
GO
ALTER TABLE [dbo].[tblMatch]  WITH CHECK ADD  CONSTRAINT [FK_tblMatch_tblTeam] FOREIGN KEY([idHomeTeam])
REFERENCES [dbo].[tblTeam] ([id])
GO
ALTER TABLE [dbo].[tblMatch] CHECK CONSTRAINT [FK_tblMatch_tblTeam]
GO
ALTER TABLE [dbo].[tblMatch]  WITH CHECK ADD  CONSTRAINT [FK_tblMatch_tblTeam1] FOREIGN KEY([idClientTeam])
REFERENCES [dbo].[tblTeam] ([id])
GO
ALTER TABLE [dbo].[tblMatch] CHECK CONSTRAINT [FK_tblMatch_tblTeam1]
GO
ALTER TABLE [dbo].[tblPlayer]  WITH CHECK ADD  CONSTRAINT [FK_tblPlayer_tblTeam] FOREIGN KEY([idTeam])
REFERENCES [dbo].[tblTeam] ([id])
GO
ALTER TABLE [dbo].[tblPlayer] CHECK CONSTRAINT [FK_tblPlayer_tblTeam]
GO
