/*
工资单计算
*/
object tt{
	def main(args:Array[String]):Unit = {
		case class Employee(name:String,title:String,annualSalary:Double,taxRate:Double,insurancePermiumsPerWeek:Double)

		val employees = List(Employee("Buck Trends", "CEO", 200000, 0.25, 100.0),Employee("Cindy Banks", "CFO", 170000, 0.22, 120.0),Employee("Joe Coder", "Developer", 130000, 0.20, 120.0))

		//calculator salary of peer week
		val netPay = employees map{
			e => val net=(1.0 - e.taxRate)*(e.annualSalary/52.0) - e.insurancePermiumsPerWeek
			(e,net)
		}

		//print
		println()
		netPay.foreach{
			case (e,net) => println(f" ${e.name+':'}%-16s ${net}%10.2f")
		}

		//product report
		val report = (netPay foldLeft(0.0,0.0,0.0)){
			case ((totalSalary,totalNet,totalInsurance),(e,net)) =>
			(totalSalary + e.annualSalary/52.0,
			totalNet + net,
			totalInsurance + e.insurancePermiumsPerWeek)
		}
		println("\n** Report:")
		println(f" Total Salary: ${report._1}%10.2f")
		println(f" Total Net: ${report._2}%10.2f")
		println(f" Total Insurance: ${report._3}%10.2f")
	}
}

