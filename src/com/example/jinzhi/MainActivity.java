package com.example.jinzhi;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnFocusChangeListener, TextWatcher, OnClickListener{
	EditText focus,edit1,edit2,edit3,edit4;
	Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18;
	EditText[] edits;
	Button[] buttons;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edit1=(EditText)findViewById(R.id.editText1);
		edit2=(EditText)findViewById(R.id.editText2);
		edit3=(EditText)findViewById(R.id.editText3);
		edit4=(EditText)findViewById(R.id.editText4);
		focus=edit1;
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		button3=(Button)findViewById(R.id.button3);
		button4=(Button)findViewById(R.id.button4);
		button5=(Button)findViewById(R.id.button5);
		button6=(Button)findViewById(R.id.button6);
		button7=(Button)findViewById(R.id.button7);
		button8=(Button)findViewById(R.id.button8);
		button9=(Button)findViewById(R.id.button9);
		button10=(Button)findViewById(R.id.button10);
		button11=(Button)findViewById(R.id.button11);
		button12=(Button)findViewById(R.id.button12);
		button13=(Button)findViewById(R.id.button13);
		button14=(Button)findViewById(R.id.button14);
		button15=(Button)findViewById(R.id.button15);
		button16=(Button)findViewById(R.id.button16);
		button17=(Button)findViewById(R.id.button17);
		button18=(Button)findViewById(R.id.button18);
		edits=new EditText[]{edit1,edit2,edit3,edit4};
		buttons=new Button[]{button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18};

		for(EditText i : edits) {
			i.setOnFocusChangeListener(this);
			i.addTextChangedListener(this);
		}
		for(Button i : buttons) {
			i.setOnClickListener(this);
		}
		button18.setOnLongClickListener(new OnLongClickListener() {
			@Override	//长按清空输入框
			public boolean onLongClick(View v) {
				focus.setText("");
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.action_help:
			String text = "欢迎使用comiee制作的进制转换器！\n"
						+ "输入数字即可自动转换，赶快试试吧！";
			Toast.makeText(this, text, Toast.LENGTH_LONG).show();
			return true;
		case R.id.action_exit:
			this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override	//焦点改变
	public void onFocusChange(View v, boolean hasFocus) {
		if(hasFocus) {
			this.focus = (EditText)findViewById(v.getId());
		}
	}

	@Override	//文本改变前
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
	@Override	//文本改变中
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		String out1="",out2="",out3="",out4="";
		if(focus==edit1) {
			out1 = s.toString();
			out2 = Conversion.z10_2(out1);
			out3 = Conversion.z2_8(out2);
			out4 = Conversion.z2_16(out2);
		}
		if(focus==edit2) {
			out2 = s.toString();
			out1 = Conversion.z2_10(out2);
			out3 = Conversion.z2_8(out2);
			out4 = Conversion.z2_16(out2);
		}
		if(focus==edit3) {
			out3 = s.toString();
			out2 = Conversion.z8_2(out3);
			out1 = Conversion.z2_10(out2);
			out4 = Conversion.z2_16(out2);
		}
		if(focus==edit4) {
			out4 = s.toString();
			out2 = Conversion.z16_2(out4);
			out1 = Conversion.z2_10(out2);
			out3 = Conversion.z2_8(out2);
		}
		//必须先移除监听器，否则会导致栈溢出
		for(EditText i : edits) {
			i.removeTextChangedListener(this);
		}
		int index=out2.indexOf(".");	//限制二进制显示的小数为16位
		if (index>0 && out2.substring(index+1,out2.length()).length()>16) out2=out2.substring(0,index+1+16);
		edit1.setText(out1);
		edit2.setText(out2);
		edit3.setText(out3);
		edit4.setText(out4);
		for(EditText i : edits) {
			i.addTextChangedListener(this);
		}	//之后需要重新设置光标位置
		focus.setSelection(start+count);
	}
	@Override	//文本改变后
	public void afterTextChanged(Editable s) {}

	@Override	//点击按钮
	public void onClick(View v) {
		Button button = (Button)findViewById(v.getId());
		int index=focus.getSelectionStart();
		String text="";
		switch (v.getId()) {
		case R.id.button1:
		case R.id.button2:
		case R.id.button3:
		case R.id.button4:
		case R.id.button5:
		case R.id.button6:
		case R.id.button7:
		case R.id.button8:
		case R.id.button9:
		case R.id.button10:
		case R.id.button11:
		case R.id.button12:
		case R.id.button13:
		case R.id.button14:
		case R.id.button15:
		case R.id.button16:
		case R.id.button17:
			text=button.getText().toString();
			focus.getText().insert(index, text);
			break;
		case R.id.button18:
			if(index>0) {
				focus.getText().delete(index-1, index);
			}
			break;
		}
	}
}
