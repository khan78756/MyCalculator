package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.AccessNetworkConstants
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.TextView
import com.example.mycalculator.databinding.ActivityMainBinding
import org.mozilla.javascript.Script
import org.mozilla.javascript.ast.EmptyExpression
import java.lang.Exception
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {
    lateinit var expression: TextView
    lateinit var result: TextView
    lateinit var clear: Button
    lateinit var left_bracket: Button
    lateinit var right_bracket: Button
    lateinit var division: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var multiple: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var minus: Button
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var plus: Button
    lateinit var zero: Button
    lateinit var dot: Button
    lateinit var equal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Get Button


        //Get Button View By Id
        expression=findViewById(R.id.expression)
        result=findViewById(R.id.result)
        clear=findViewById(R.id.clear)
        left_bracket=findViewById(R.id.left_bracket)
        right_bracket=findViewById(R.id.rigth_bracket)
        division=findViewById(R.id.division)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        multiple=findViewById(R.id.multiply)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        minus=findViewById(R.id.minus)
        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        plus=findViewById(R.id.plus)
        zero=findViewById(R.id.zero)
        dot=findViewById(R.id.dot)
        equal=findViewById(R.id.equal)

        //For movement of values in Expression

        expression.movementMethod=ScrollingMovementMethod()
        expression.isActivated=true
        expression.isPressed=true
        var str: String

        //now time for clicklisner

        clear.setOnClickListener {
            expressiontext("")
            resulttext()

        }
        left_bracket.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "("
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "("
                expressiontext(str)
                resulttext()
            }

        }
        right_bracket.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + ")"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + ")"
                expressiontext(str)
                resulttext()
            }

        }
        division.setOnClickListener {
            if(expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("(")||expression.text.toString().endsWith(")")){
            str = expression.text.toString()
                expressiontext(str)
            }
            else{
                str=expression.text.toString()+"/"
                expressiontext(str)
            }
        }
        seven.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "7"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "7"
                expressiontext(str)
                resulttext()
            }

        }
        eight.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "8"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "8"
                expressiontext(str)
                resulttext()
            }

        }
        nine.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "9"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "9"
                expressiontext(str)
                resulttext()
            }

        }
        multiple.setOnClickListener {
            if(expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("(")||expression.text.toString().endsWith(")")){
                str = expression.text.toString()
                expressiontext(str)
            }
            else{
                str=expression.text.toString()+"*"
                expressiontext(str)
            }


        }
        four.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "4"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "4"
                expressiontext(str)
                resulttext()
            }

        }
        five.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "5"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "5"
                expressiontext(str)
                resulttext()
            }

        }
        six.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "6"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "6"
                expressiontext(str)
                resulttext()
            }

        }
        minus.setOnClickListener {
            if(expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("(")||expression.text.toString().endsWith(")")){
                str = expression.text.toString()
                expressiontext(str)
            }
            else{
                str=expression.text.toString()+"-"
                expressiontext(str)
            }

        }
        one.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "1"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "1"
                expressiontext(str)
                resulttext()
            }

        }
        two.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "2"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "2"
                expressiontext(str)
                resulttext()
            }

        }
        three.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "3"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "3"
                expressiontext(str)
                resulttext()
            }

        }
        plus.setOnClickListener {
            if(expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("(")||expression.text.toString().endsWith(")")){
                str = expression.text.toString()
                expressiontext(str)
            }
            else{
                str=expression.text.toString()+"+"
                expressiontext(str)
            }

        }
        zero.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "0"
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "0"
                expressiontext(str)
                resulttext()
            }

        }
        dot.setOnClickListener {
            if(expression.text.toString().startsWith("0")) {
                str = expression.text.toString().replace("0", " ") + "."
                expressiontext(str)
                resulttext()
            }
            else {
                str = expression.text.toString() + "."
                expressiontext(str)
                resulttext()
            }

        }
        equal.setOnClickListener {
            str= result.text.toString().replace("= ","")
            expression.text= str
            result.text=result.text.toString()

        }
    }
     private fun expressiontext(str: String) {
         expression =findViewById(R.id.expression)
         expression.text=str
    }
    private fun resulttext() {
        expression=findViewById(R.id.expression)
        var exp=expression.text.toString()
        result=findViewById(R.id.result)
        //Engine Calling
        val engine:ScriptEngine= ScriptEngineManager().getEngineByName("rhino")

        try {
            val res=engine.eval(exp)
            if(res.toString().endsWith(".0"))
            result.text= res.toString().replace(".0","")
            else
                result.text=  res.toString()
        }catch (e:Exception)
        {
            expression.text=expression.text.toString()
            result.text=result.text.toString()

        }

    }
}