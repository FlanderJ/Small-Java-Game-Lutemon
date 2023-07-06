package com.example.lutemon.viewAndActivities;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lutemon.R;
import com.example.lutemon.lutemons.Lutemon;
import com.example.lutemon.lutemons.Storage;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class BattleFieldActivity extends AppCompatActivity {

    private Lutemon fighter1 = null, fighter2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battlefield);
        createLutemonSelection();

        // Click listener for "Fight!" button:
        Button btCombat = findViewById(R.id.btCombat);
        btCombat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelectedFighters();
                changeVisibilityOfElementsOnView();
                setFighterInfo();
                combat();
            }
        });
    }


    // Form Lutemon selection by using Checkboxes:
    public void createLutemonSelection() {
        int i = 0;
        // Get the LinearLayout from fragment:
        LinearLayout llLutemonsAtCombat = findViewById(R.id.llLutemonCombat);
        for (Lutemon lutemon : Storage.getInstance().getLutemons()) {
            if ("Combat".equals(lutemon.getLocation())) {
                CheckBox cbLutemonAtHome = new CheckBox(this);
                cbLutemonAtHome.setText(lutemon.getName() + " (" + lutemon.getClass().getSimpleName() + ")");
                cbLutemonAtHome.setTag(lutemon.getName());
                llLutemonsAtCombat.addView(cbLutemonAtHome);
            }
        }
    }
    public void getSelectedFighters() {
        LinearLayout llLutemonsAtCombat = findViewById(R.id.llLutemonCombat);
        for (int i=0; i < llLutemonsAtCombat.getChildCount(); i++) {
            CheckBox cbLutemon = (CheckBox) llLutemonsAtCombat.getChildAt(i);
            if (cbLutemon.isChecked()) {
                if (fighter1 == null) {
                    String selectedLutemon = (String) cbLutemon.getTag();
                    fighter1 = Storage.getInstance().getLutemonByName(selectedLutemon);
                    continue;
                }
                if(fighter2 == null) {
                    String selectedLutemon = (String) cbLutemon.getTag();
                    fighter2 = Storage.getInstance().getLutemonByName(selectedLutemon);
                    break;
                }
            }
        }
    }

    public void changeVisibilityOfElementsOnView() {
        // Make default elements disappear:
        LinearLayout llLutemonsAtCombat = findViewById(R.id.llLutemonCombat);
        Button btCombat = findViewById(R.id.btCombat);
        TextView tvInfo = findViewById(R.id.tvInfo);

        llLutemonsAtCombat.setVisibility(View.GONE);
        btCombat.setVisibility(View.GONE);
        tvInfo.setVisibility(View.GONE);

        // Make combat elements appear:
        LinearLayout llFighter1 = findViewById(R.id.llFighter1);
        LinearLayout llFighter2 = findViewById(R.id.llFighter2);
        EditText etCombatInfo = findViewById(R.id.etCombatInfo);

        llFighter1.setVisibility(View.VISIBLE);
        llFighter2.setVisibility(View.VISIBLE);
        etCombatInfo.setVisibility(View.VISIBLE);
    }

    public void setFighterInfo() {
        ImageView imgFighter1 = findViewById(R.id.imgLutemon);
        ImageView imgFighter2 = findViewById(R.id.imgLutemon2);
        EditText etNameF1 = findViewById(R.id.etNameCombat);
        EditText etNameF2 = findViewById(R.id.etNameCombat2);
        EditText etAtt1 = findViewById(R.id.etAttackCombat);
        EditText etAtt2 = findViewById(R.id.etAttackCombat2);
        EditText etDef1 = findViewById(R.id.etDefCombat);
        EditText etDef2 = findViewById(R.id.etDefCombat2);
        EditText etDodge1 = findViewById(R.id.etDodgeCombat);
        EditText etDodge2 = findViewById(R.id.etDodgeCombat2);
        EditText etHealth1 = findViewById(R.id.etHealthCombat);
        EditText etHealth2 = findViewById(R.id.etHealthCombat2);
        EditText etExp1 = findViewById(R.id.etExpCombat);
        EditText etExp2 = findViewById(R.id.etExpCombat2);

        imgFighter1.setImageResource(fighter1.getPhoto());
        imgFighter2.setImageResource(fighter2.getPhoto());
        etNameF1.setText(fighter1.getName());
        etNameF2.setText(fighter2.getName());
        etAtt1.setText("Attack: " + String.valueOf(fighter1.getAttack()));
        etAtt2.setText("Attack: " + String.valueOf(fighter2.getAttack()));
        etDef1.setText("Defence:" + String.valueOf(fighter1.getAttack()));
        etDef2.setText("Defence: " + String.valueOf(fighter2.getAttack()));
        etDodge1.setText("Dodge: " + String.valueOf(fighter1.getDodge()));
        etDodge2.setText("Dodge: " + String.valueOf(fighter2.getDodge()));
        etHealth1.setText("Health: " + String.valueOf(fighter1.getHealth()) + "/" + String.valueOf(fighter1.getMaxHealth()));
        etHealth2.setText("Health: " + String.valueOf(fighter2.getHealth()) + "/" + String.valueOf(fighter2.getMaxHealth()));
        etExp1.setText("Experience: " + String.valueOf(fighter1.getExperience()));
        etExp2.setText("Experience: " + String.valueOf(fighter2.getExperience()));
    }

    public interface OnEndAction {
        void execute();
    }

    public void combat() {
        ImageView imgAttack1 = findViewById(R.id.imgAttack1);
        ImageView imgAttack2 = findViewById(R.id.imgAttack2);

        // Aloita taistelu kutsumalla tätä metodia
        combatRound(imgAttack1, imgAttack2, fighter1, fighter2, 0);
    }

    private void combatRound(final ImageView imgAttack1, final ImageView imgAttack2, final Lutemon fighter1, final Lutemon fighter2, final int i) {
        // Check if the battle is over:
        if (fighter1.getHealth() <= 0 || fighter2.getHealth() <= 0 || i > 100) {
            return;
        }

        imgAttack1.setVisibility(View.VISIBLE);
        attack(fighter1, fighter2, new OnEndAction() {
            // Define what happens after each attack of fighter1:
            @Override
            public void execute() {
                imgAttack1.setVisibility(View.GONE);

                if (fighter2.getHealth() <= 0) {
                    return;
                }

                imgAttack2.setVisibility(View.VISIBLE);
                attack(fighter2, fighter1, new OnEndAction() {
                    // Define what happens after each attack of fighter2:
                    @Override
                    public void execute() {
                        imgAttack2.setVisibility(View.GONE);
                        if (fighter1.getHealth() <= 0) {
                            return;
                        }

                        // If the fight is not over, start new round
                        combatRound(imgAttack1, imgAttack2, fighter1, fighter2, i + 1);
                    }
                });
            }
        });
    }


    public void attack(Lutemon attacker, Lutemon defender,  final OnEndAction onEnd) {
        EditText etCombatinfo = findViewById(R.id.etCombatInfo);

        Random rand = new Random();
        float instance = rand.nextFloat();
        float dodgeChance = defender.getDodge()/attacker.getAttack();
        System.out.println(dodgeChance);
        if (dodgeChance > 0 && 0.5*dodgeChance > instance) {
            ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
            animator.setDuration(1000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    etCombatinfo.setText(attacker.getName() + " misses!");
                }
            });
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {}

                @Override
                public void onAnimationEnd(Animator animator) {
                    updateHealth();
                    onEnd.execute();
                }

                @Override
                public void onAnimationCancel(Animator animator) {}

                @Override
                public void onAnimationRepeat(Animator animator) {}
            });

            animator.start();
        }

        else {
            int damage = (int) (attacker.getAttack() - (defender.getDefence()*(rand.nextFloat() * (1 - 0.1f) + 0.1f)));

            if (damage >= defender.getHealth()) {
                defender.setHealth(0);
                updateHealth();
                etCombatinfo.setText(attacker.getName() + " WINS!");
                afterFightStats(attacker,defender);
                return;
            }else {
                defender.setHealth(defender.getHealth() - damage);
            }
            ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
            animator.setDuration(1000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    String text = attacker.getName() + " hits with " + String.valueOf(damage) + "!";
                    SpannableString spannable = new SpannableString(text);

                    int end = text.length();
                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    etCombatinfo.setText(spannable);
                }
            });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {}

            @Override
            public void onAnimationEnd(Animator animator) {
                updateHealth();
                onEnd.execute();
            }

            @Override
            public void onAnimationCancel(Animator animator) {}

            @Override
            public void onAnimationRepeat(Animator animator) {}
        });

        animator.start();
    }
        }

    public void updateHealth() {
        EditText etHealth1 = findViewById(R.id.etHealthCombat);
        EditText etHealth2 = findViewById(R.id.etHealthCombat2);
        etHealth1.setText("Health: " + String.valueOf(fighter1.getHealth()) + "/" + String.valueOf(fighter1.getMaxHealth()));
        etHealth2.setText("Health: " + String.valueOf(fighter2.getHealth()) + "/" + String.valueOf(fighter2.getMaxHealth()));
    }

    public void afterFightStats (Lutemon winner, Lutemon loser) {
        winner.increaseStatsAfterWin();
        loser.increaseLoser();
        Storage.getInstance().saveLutemons();
    }
}
