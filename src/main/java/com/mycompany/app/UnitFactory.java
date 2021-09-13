package com.mycompany.app;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import com.mycompany.app.AttackStrategiesFolder.AttackStrategy;
import com.mycompany.app.UnitPropertiesFolder.ArmorUnitProperty;
import com.mycompany.app.UnitPropertiesFolder.AttackDamageProperty;
import com.mycompany.app.UnitPropertiesFolder.AttackFrequencyProperty;
import com.mycompany.app.UnitPropertiesFolder.AttackRangeProperty;
import com.mycompany.app.UnitPropertiesFolder.HealthUnitProperty;
import com.mycompany.app.UnitPropertiesFolder.MovementSpeedProperty;
import com.mycompany.app.UnitPropertiesFolder.UnitPriceProperty;
import com.mycompany.app.UnitPropertiesFolder.UnitProperty;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UnitFactory {

    public Unit CreateUnit(UnitType unitType , AttackStrategy attackStrategy)
    {
        Unit MyUnit = new Unit();
        try{
            File file = new File("AppendixA.xlsx"); // creating a new file instance
            FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
            // creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator(); // iterating over excel file
            Row row=itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            UnitProperty [] unitProperties = new UnitProperty[7];
            UnitPosition unitPosition = new UnitPosition() ;
            
            switch(unitType)
            {

                case TeslaTank :  
                MyUnit.setUnitName(unitType);
                MyUnit.setUnitType(UnitType.Tank);
                row=itr.next();
                cellIterator = row.cellIterator();
                 Cell cell = cellIterator.next();
                 cell = cellIterator.next();

                 cell = cellIterator.next();
                 unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                 
                 cell = cellIterator.next();
                 unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitPosition.setRadius((int)cell.getNumericCellValue());
                 MyUnit.setPosition(unitPosition);

                 cell = cellIterator.next();
                 unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 MyUnit.canAttack.add(UnitType.Tank);
                 MyUnit.canAttack.add(UnitType.Solider);


                 cell = cellIterator.next();
                 unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());
                 MyUnit.setAttackStrategy(attackStrategy);
                break ;
    
                case Sniper :
                 MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Solider);
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Solider);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());
                  MyUnit.setAttackStrategy(attackStrategy);
 
                break ;
    
                case MirageTank:
                 MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Tank);
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Solider);
                  MyUnit.canAttack.add(UnitType.Tank);
                  MyUnit.canAttack.add(UnitType.Structure);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());

                  MyUnit.setAttackStrategy(attackStrategy);
 
                break ;
    
                case Infantry:
                 MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Solider);
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Solider);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());

                  MyUnit.setAttackStrategy(attackStrategy);
 
                break;
    
                case GrizzlyTank :
                 MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Tank);
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Solider);
                  MyUnit.canAttack.add(UnitType.Tank);
                  MyUnit.canAttack.add(UnitType.Structure);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());
 
                  MyUnit.setAttackStrategy(attackStrategy);

                break;
    
                case NavySEAL :
                MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Solider);
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Solider);
                  MyUnit.canAttack.add(UnitType.Tank);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());
 
                  MyUnit.setAttackStrategy(attackStrategy);
                break ;
    
                case TankDestroyer :
                MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Tank);
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Tank);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());
 
                  MyUnit.setAttackStrategy(attackStrategy);
                break ;
    
                case PrismTank:
                MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Tank);
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Solider);
                  MyUnit.canAttack.add(UnitType.Tank);
                  MyUnit.canAttack.add(UnitType.Structure);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());
 
                  MyUnit.setAttackStrategy(attackStrategy);
                break ;
              
    
                case Pillbox:
                MyUnit.setUnitName(unitType);
                 MyUnit.setUnitType(UnitType.Structure);
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 row=itr.next();
                 cellIterator = row.cellIterator();
                  cell = cellIterator.next();
                  cell = cellIterator.next();
 
                  cell = cellIterator.next();
                  unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                  
                  cell = cellIterator.next();
                  unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  unitPosition.setRadius((int)cell.getNumericCellValue());
                  MyUnit.setPosition(unitPosition);
 
                  cell = cellIterator.next();
                  unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());
 
                  cell = cellIterator.next();
                  MyUnit.canAttack.add(UnitType.Solider);
 
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());
 
                  MyUnit.setAttackStrategy(attackStrategy);
                break;
                
                case PrismTower :
                MyUnit.setUnitName(unitType);
                MyUnit.setUnitType(UnitType.Structure);
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                cellIterator = row.cellIterator();
                 cell = cellIterator.next();
                 cell = cellIterator.next();

                 cell = cellIterator.next();
                 unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                 
                 cell = cellIterator.next();
                 unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitPosition.setRadius((int)cell.getNumericCellValue());
                 MyUnit.setPosition(unitPosition);

                 cell = cellIterator.next();
                 unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 MyUnit.canAttack.add(UnitType.Solider);
                 MyUnit.canAttack.add(UnitType.Tank);

                 cell = cellIterator.next();
                 unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());

                 MyUnit.setAttackStrategy(attackStrategy);
                break;
    
                case GrandCannon :
                MyUnit.setUnitName(unitType);
                MyUnit.setUnitType(UnitType.Structure);
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                cellIterator = row.cellIterator();
                 cell = cellIterator.next();
                 cell = cellIterator.next();

                 cell = cellIterator.next();
                 unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                 
                 cell = cellIterator.next();
                 unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitPosition.setRadius((int)cell.getNumericCellValue());
                 MyUnit.setPosition(unitPosition);

                 cell = cellIterator.next();
                 unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 MyUnit.canAttack.add(UnitType.Solider);
                 MyUnit.canAttack.add(UnitType.Tank);

                 cell = cellIterator.next();
                 unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());

                 MyUnit.setAttackStrategy(attackStrategy);
                break ;
    
                case MAINBASE:
                MyUnit.setUnitName(unitType);
                MyUnit.setUnitType(UnitType.Structure);
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                cellIterator = row.cellIterator();
                 cell = cellIterator.next();
                 cell = cellIterator.next();

                 cell = cellIterator.next();
                 unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                 
                 cell = cellIterator.next();
                 unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitPosition.setRadius((int)cell.getNumericCellValue());
                 MyUnit.setPosition(unitPosition);

                 cell = cellIterator.next();
                 unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                  cell = cellIterator.next();
                  unitProperties[6] = new UnitPriceProperty(0);

                break ;
    
                case BlackEagle:
                MyUnit.setUnitName(unitType);
                MyUnit.setUnitType(UnitType.Airplane);
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                cellIterator = row.cellIterator();
                 cell = cellIterator.next();
                 cell = cellIterator.next();

                 cell = cellIterator.next();
                 unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 //
                // unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                 unitProperties[2] = new AttackDamageProperty(400);

                 
                 cell = cellIterator.next();
                 //-------------
                // unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());
                 unitProperties[3] = new AttackRangeProperty(30);

                 //------------

                 cell = cellIterator.next();
                 unitProperties[4] = new AttackFrequencyProperty(100);

                 cell = cellIterator.next();
                 unitPosition.setRadius(0);
                  MyUnit.setPosition(unitPosition);

                 cell = cellIterator.next();
                 unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 MyUnit.canAttack.add(UnitType.Structure);

                 cell = cellIterator.next();
                 unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());

                 MyUnit.setAttackStrategy(attackStrategy);
                break;
                
                case PatriotMissileSystem :
                MyUnit.setUnitName(unitType);
                MyUnit.setUnitType(UnitType.Structure);
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                row=itr.next();
                cellIterator = row.cellIterator();
                 cell = cellIterator.next();
                 cell = cellIterator.next();

                 cell = cellIterator.next();
                 unitProperties[0] = new HealthUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[1] = new ArmorUnitProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[2] = new AttackDamageProperty(cell.getNumericCellValue());
                 
                 cell = cellIterator.next();
                 unitProperties[3] = new AttackRangeProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitProperties[4] = new AttackFrequencyProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 unitPosition.setRadius((int)cell.getNumericCellValue());
                 MyUnit.setPosition(unitPosition);

                 cell = cellIterator.next();
                 unitProperties[5] = new MovementSpeedProperty(cell.getNumericCellValue());

                 cell = cellIterator.next();
                 MyUnit.canAttack.add(UnitType.Airplane);

                 cell = cellIterator.next();
                 unitProperties[6] = new UnitPriceProperty(cell.getNumericCellValue());

                 MyUnit.setAttackStrategy(attackStrategy);
                break;
    
                
                        
                case Valley:
                MyUnit.setUnitName(unitType);
                MyUnit.setUnitType(UnitType.Valley);
                
                unitProperties[0] = new HealthUnitProperty(0);

                 unitProperties[1] = new ArmorUnitProperty(0);

                 unitProperties[2] = new AttackDamageProperty(0);
                                
                 unitProperties[3] = new AttackRangeProperty(0);

                 unitProperties[4] = new AttackFrequencyProperty(0);
              
                 unitPosition.setRadius(10);
                 MyUnit.setPosition(unitPosition);
                
                 unitProperties[5] = new MovementSpeedProperty(0);
                 
                 //MyUnit.canAttack.add(UnitType.Airplane);
  
                 unitProperties[6] = new UnitPriceProperty(0);

                 MyUnit.setAttackStrategy(attackStrategy);

                break;

                
                
                default :
              
                
            }
    
            MyUnit.setUnitProperties(unitProperties);

        }

         catch (Exception e) {
                e.getMessage();
            }
       

            return MyUnit;
    }
    
    
}