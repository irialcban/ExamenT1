package com.pmdm.exament1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.DecimalFormat

class ReservaActivity : AppCompatActivity() {
    private lateinit var cvTable1: CardView
    private lateinit var cvTable2: CardView
    private lateinit var cvTable3: CardView
    private var numAsientos = 0
    private lateinit var tvName: TextView
    private lateinit var btnLeft: FloatingActionButton
    private lateinit var btnRight: FloatingActionButton
    private var isLeftSelected = false
    private lateinit var tvTime: TextView
    private var time = 20
    private lateinit var btnCheck: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        cvTable1 = findViewById(R.id.cvTable1)
        cvTable2 = findViewById(R.id.cvTable2)
        cvTable3 = findViewById(R.id.cvTable3)
        tvName = findViewById(R.id.tvName)
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        tvTime = findViewById(R.id.tvTime)
        btnCheck = findViewById(R.id.btnCheck)
    }

    private fun initListeners() {
        cvTable1.setOnClickListener {
            numAsientos = 2

            cvTable1.setCardBackgroundColor(getColor(R.color.element_sel))
            cvTable2.setCardBackgroundColor(getColor(R.color.element))
            cvTable3.setCardBackgroundColor(getColor(R.color.element))
        }

        cvTable2.setOnClickListener {
            numAsientos = 4

            cvTable1.setCardBackgroundColor(getColor(R.color.element))
            cvTable2.setCardBackgroundColor(getColor(R.color.element_sel))
            cvTable3.setCardBackgroundColor(getColor(R.color.element))
        }

        cvTable3.setOnClickListener {
            numAsientos = 8

            cvTable1.setCardBackgroundColor(getColor(R.color.element))
            cvTable2.setCardBackgroundColor(getColor(R.color.element))
            cvTable3.setCardBackgroundColor(getColor(R.color.element_sel))
        }

        btnLeft.setOnClickListener {
            isLeftSelected = true
            setTime()
        }

        btnRight.setOnClickListener {
            isLeftSelected = false
            setTime()
        }

        btnCheck.setOnClickListener {
            navigate2result()
        }
    }

    private fun setTime() {
        if(isLeftSelected) {
            if(time > 20) {
                time = time - 1
            }
        }else {
            if(time < 23) {
                time = time + 1
            }
        }

        tvTime.text = DecimalFormat("#.##").format(time) + ":00"
    }

    private fun navigate2result() {
        var intentRA = Intent(this,ResultActivity::class.java)

        var name = tvName.text.toString()

        intentRA.putExtra("EXTRA_CHAIRS",numAsientos.toString())
        intentRA.putExtra("EXTRA_NAME",name)
        intentRA.putExtra("EXTRA_TIME",time.toString())

        startActivity(intentRA)
    }

    private fun initUI() {
        setTime()
    }
}