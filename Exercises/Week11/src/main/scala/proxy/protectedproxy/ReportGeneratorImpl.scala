package proxy.protectedproxy

class ReportGeneratorImpl extends ReportGenerator {
  override def generateDailyReport(): String =
    "********************Location X Daily Report********************" +
    "\nLocation ID: 012\nToday’s Date: Sun Sep 14 13:28:12 IST 2014" +
    "\nTotal Pizza Sell: 112\nTotal Sale: $2534\nNet Profit: $1985" +
    "\n***************************************************************"
}
